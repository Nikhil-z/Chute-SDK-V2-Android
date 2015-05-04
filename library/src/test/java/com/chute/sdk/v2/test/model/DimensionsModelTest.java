package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.DimensionsModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

import junit.framework.TestCase;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public class DimensionsModelTest extends TestCase {

	public void testDimensionsModel() throws JsonProcessingException,
      CreateModelException, JSONException {
		DimensionsModel model = FactoryManager.getModelFactory().createModel(
				DimensionsModel.class);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"dimensionsModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("width", "height"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/DimensionsModel.json");
    JSONAssert.assertEquals(expected, result, false);
	}

}
