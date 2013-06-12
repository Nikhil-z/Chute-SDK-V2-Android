package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.SourceModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;

import junit.framework.TestCase;

public class SourceModelTest extends TestCase {

	public void testSourceModel() throws JsonProcessingException,
			CreateModelException {
		SourceModel model = FactoryManager.getModelFactory().createModel(
				SourceModel.class);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"sourceModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("source", "source_id",
								"source_url", "service", "import_id",
								"import_url"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = "{\"source\":\"chute\",\"service\":\"uploaded\",\"source_id\":\"123bg\",\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg\",\"import_id\":\"3213asd\",\"import_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg\"}";
		assertEquals(expected, result);

	}

}
