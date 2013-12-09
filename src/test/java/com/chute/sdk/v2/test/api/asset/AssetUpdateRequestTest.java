package com.chute.sdk.v2.test.api.asset;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

public class AssetUpdateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
			throws JsonProcessingException, CreateModelException {
		AssetModel asset = FactoryManager.getModelFactory().createModel(
				AssetModel.class);
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"assetModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("caption", "votes", "hearts"));
		String result = JsonUtil.getMapper().writer(filter)
				.writeValueAsString(asset);
		String expected = TestUtil
				.readResourceAsString("request/AssetUpdate.json");
		assertEquals(expected, result);
	}
}
