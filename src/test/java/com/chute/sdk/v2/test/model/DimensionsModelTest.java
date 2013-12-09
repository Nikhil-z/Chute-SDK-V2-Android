package com.chute.sdk.v2.test.model;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.DimensionsModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

public class DimensionsModelTest extends TestCase {

	public void testDimensionsModel() throws JsonProcessingException,
			CreateModelException {
		DimensionsModel model = FactoryManager.getModelFactory().createModel(
				DimensionsModel.class);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"dimensionsModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("width", "height"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/DimensionsModel.json");
		assertEquals(expected, result);

	}

}
