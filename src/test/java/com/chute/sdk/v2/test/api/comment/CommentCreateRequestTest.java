package com.chute.sdk.v2.test.api.comment;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tobedevoured.modelcitizen.CreateModelException;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public class CommentCreateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
      throws JsonProcessingException, CreateModelException, JSONException {
		CommentModel comment = FactoryManager.getModelFactory().createModel(
				CommentModel.class);
		String result = comment.serializeComment();
		String expected = TestUtil
				.readResourceAsString("request/CommentCreate.json");
    JSONAssert.assertEquals(expected, result, false);
	}
}
