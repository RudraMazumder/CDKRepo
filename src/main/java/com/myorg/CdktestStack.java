package com.myorg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.IPeer;
import software.amazon.awscdk.services.ec2.ISecurityGroup;
import software.amazon.awscdk.services.ec2.ISubnet;
import software.amazon.awscdk.services.ec2.InstanceClass;
import software.amazon.awscdk.services.ec2.InstanceSize;
import software.amazon.awscdk.services.ec2.InstanceType;
import software.amazon.awscdk.services.ec2.Peer;
import software.amazon.awscdk.services.ec2.Port;
import software.amazon.awscdk.services.ec2.SecurityGroup;
import software.amazon.awscdk.services.ec2.Subnet;
import software.amazon.awscdk.services.ec2.SubnetSelection;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecr.assets.DockerImageAsset;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.ICluster;
import software.amazon.awscdk.services.ecs.Secret;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.amazon.awscdk.services.eks.FargateCluster;
import software.amazon.awscdk.services.rds.Credentials;
import software.amazon.awscdk.services.rds.DatabaseInstance;
import software.amazon.awscdk.services.rds.DatabaseInstanceEngine;
import software.amazon.awscdk.services.rds.MySqlInstanceEngineProps;
import software.amazon.awscdk.services.rds.MysqlEngineVersion;

import software.constructs.Construct;

public class CdktestStack extends Stack {
	public CdktestStack(final Construct parent, final String id) {
		this(parent, id, null);
	}

	public CdktestStack(final Construct parent, final String id, final StackProps props) {
		super(parent, id, props);

//		final Queue queue = Queue.Builder.create(this, "CdktestQueue").visibilityTimeout(Duration.seconds(300)).build();
//
//		final Topic topic = Topic.Builder.create(this, "CdktestTopic").displayName("My First Topic Yeah").build();
//
//		topic.addSubscription(new SqsSubscription(queue));

		createECSCluster();

	}

	private void createECSCluster() {
		Vpc vpc = Vpc.Builder.create(this, "MyVpc").maxAzs(3) // Default is all AZs in region
				.build();

		Cluster cluster = Cluster.Builder.create(this, "MyCluster").vpc(vpc).build();

		@NotNull
		Credentials credentials = Credentials.fromGeneratedSecret("testUser");
		String dbName="testDB";

		DatabaseInstance instance = DatabaseInstance.Builder.create(this, dbName).databaseName(dbName).vpc(vpc)
				.engine(DatabaseInstanceEngine
						.mysql(MySqlInstanceEngineProps.builder().version(MysqlEngineVersion.VER_5_7).build()))
				.credentials(credentials).instanceType(InstanceType.of(InstanceClass.BURSTABLE2, InstanceSize.MICRO))
				.build();

		@NotNull
		String dbInstanceEndpointAddress = instance.getDbInstanceEndpointAddress();
		
		
		String url="jdbc:mysql://"+dbInstanceEndpointAddress+":3306/"+dbName;

		@NotNull
		Secret username = Secret.fromSecretsManager(instance.getSecret(), "username");

		@NotNull
		Secret password = Secret.fromSecretsManager(instance.getSecret(), "password");

		Map<String, String> envMap = new HashMap<String, String>();
		envMap.put("spring.datasource.url", url);

		Map<String, Secret> secretMap = new HashMap<String, Secret>();
		secretMap.put("spring.datasource.username", username);
		secretMap.put("spring.datasource.password", password);

		// Create a load-balanced Fargate service and make it public
		ApplicationLoadBalancedFargateService build = ApplicationLoadBalancedFargateService.Builder
				.create(this, "MyFargateService").cluster(cluster) // Required
				.cpu(512) // Default is 256
				.desiredCount(6) // Default is 1
				.taskImageOptions(ApplicationLoadBalancedTaskImageOptions.builder()
						.image(ContainerImage.fromDockerImageAsset(DockerImageAsset.Builder.create(this, "SpringbootApp")
								.directory("./StudentService").build())).secrets(secretMap)
						.containerPort(8080)
						.environment(envMap).build())
				.memoryLimitMiB(2048) // Default is 512
				.publicLoadBalancer(true) // Default is false
				.build();

		build.getService().getConnections().allowTo(instance, Port.tcp(3306), "Connect to DB");

	}
}
