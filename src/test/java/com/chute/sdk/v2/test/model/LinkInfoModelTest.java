package com.chute.sdk.v2.test.model;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.LinkInfoModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

public class LinkInfoModelTest extends TestCase {

	public void testLinkInfoModel() throws JsonProcessingException,
			CreateModelException {
		LinkInfoModel model = FactoryManager.getModelFactory().createModel(
				LinkInfoModel.class);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"linkInfoModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("href", "title"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/LinkInfoModel.json");
		assertEquals(expected, result);

	}

}
