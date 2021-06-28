package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.InstanceClass;
import software.amazon.awscdk.services.ec2.InstanceSize;
import software.amazon.awscdk.services.ec2.InstanceType;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.rds.Credentials;
import software.amazon.awscdk.services.rds.DatabaseInstance;
import software.amazon.awscdk.services.rds.DatabaseInstanceEngine;
import software.amazon.awscdk.services.rds.MySqlInstanceEngineProps;
import software.amazon.awscdk.services.rds.MysqlEngineVersion;
import software.constructs.Construct;

public class MyRDSStack extends Stack {
	
	
	
	private DatabaseInstance databaseInstance;
	
	public MyRDSStack(final Construct parent, final Vpc vpc, final String id) {
		this(parent, id, vpc, null);
	}

	public MyRDSStack(Construct parent, String id, final Vpc vpc, final StackProps props) {
		
		databaseInstance = DatabaseInstance.Builder.create(this, "testDB")
				.databaseName("testDB")
				.vpc(vpc)
				.engine(DatabaseInstanceEngine.mysql(MySqlInstanceEngineProps.builder().version(MysqlEngineVersion.VER_5_7).build()))
				.credentials(Credentials.fromGeneratedSecret("testUser"))
				.instanceType(InstanceType.of(InstanceClass.BURSTABLE2, InstanceSize.MICRO))
				.build();

		
	}

	public DatabaseInstance getDatabaseInstance() {
		return databaseInstance;
	}

	
	
		

}
