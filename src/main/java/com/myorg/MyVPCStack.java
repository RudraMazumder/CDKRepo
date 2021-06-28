package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;

public class MyVPCStack extends Stack{
	

	private Vpc vpc;

	
	public MyVPCStack(final Construct parent, final String id) {
		this(parent, id, null);
	}

	public MyVPCStack(Construct parent, String id, final StackProps props) {
		
		Vpc vpc = Vpc.Builder.create(this, "MyVpc").maxAzs(3) // Default is all AZs in region
				.build();

	}

	public Vpc getVpc() {
		return vpc;
	}

	public void setVpc(Vpc vpc) {
		this.vpc = vpc;
	}
		

	
}
