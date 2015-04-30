package com.chute.sdk.v2.test.model;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.SourceModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tobedevoured.modelcitizen.CreateModelException;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public class SourceModelTest extends TestCase {

	public void testSourceModel() throws JsonProcessingException,
      CreateModelException, JSONException {
		SourceModel model = FactoryManager.getModelFactory().createModel(
				SourceModel.class);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"sourceModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("source", "source_id",
								"source_url", "service", "import_id",
								"import_url"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/SourceModel.json");
    JSONAssert.assertEquals(expected, result, false);

	}

}
