package com.chute.sdk.v2.test.api.album;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

public class AlbumCreateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
			throws JsonProcessingException, CreateModelException {
		AlbumModel album = FactoryManager.getModelFactory().createModel(
				AlbumModel.class);
		FilterProvider filters = new SimpleFilterProvider().addFilter(
				"albumModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("name", "moderate_comments",
								"moderate_media"));
		String result = JsonUtil.getMapper().writer(filters)
				.writeValueAsString(album);
		assertEquals(
				"{\"name\":\"car make\",\"moderate_media\":false,\"moderate_comments\":false}",
				result);
	}
}
