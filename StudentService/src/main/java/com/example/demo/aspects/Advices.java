package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class Advices {

	private static Logger LOGGER = LoggerFactory.getLogger(Advices.class);

	@Around(value = "execution(* com.example.demo.service.*.*(..))")
	public Object logRequestResponse(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String args = toJsonString(pjp.getArgs());
		String classname = pjp.getTarget().getClass().getName();
		LOGGER.info("class name {}, method name {}, arguements {}", classname, methodName, args);
		Object proceed = null;

		proceed = pjp.proceed();
		LOGGER.info("Returned value {}", toJsonString(proceed));

		return proceed;
	}

	public String toJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String toReturn = null;

		try {
			toReturn = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("Exception occured while parsing object to JSON {}", e);
		}

		return toReturn;
	}

}
