package com.chute.sdk.v2.test.model;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.LinkModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

public class LinksModelTest extends TestCase {

	public void testLinksModel() throws CreateModelException,
			JsonProcessingException {
		LinkModel model = FactoryManager.getModelFactory().createModel(
				LinkModel.class);
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"linksModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("self"));
		String result = JsonUtil.getMapper().writer(filter)
				.writeValueAsString(model);
		String expected = "{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/364003199\",\"title\":\"Asset Details\"}}";
		assertEquals(expected, result);

	}

}
