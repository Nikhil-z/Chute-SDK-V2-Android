package com.chute.sdk.v2.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.setSerializationInclusion(Include.NON_NULL);
	}
	public static ObjectMapper getMapper() {
		return mapper;
	}

}
