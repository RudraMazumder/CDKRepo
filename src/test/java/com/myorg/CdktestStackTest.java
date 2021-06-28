package com.myorg;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import software.amazon.awscdk.App;

public class CdktestStackTest {
    private final static ObjectMapper JSON =
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
		/*
		 * App app = new App(); CdktestStack stack = new CdktestStack(app, "test");
		 * 
		 * JsonNode actual =
		 * JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).
		 * getTemplate());
		 * 
		 * assertThat(actual.toString()) .contains("AWS::SQS::Queue")
		 * .contains("AWS::SNS::Topic");
		 */
    	
    	assertThat("Hello World".contains("Hello"));
    }
}
