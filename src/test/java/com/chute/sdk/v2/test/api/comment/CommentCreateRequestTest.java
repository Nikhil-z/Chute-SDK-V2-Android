package com.chute.sdk.v2.test.api.comment;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.test.factories.FactoryManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tobedevoured.modelcitizen.CreateModelException;

public class CommentCreateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString() throws JsonProcessingException, CreateModelException {
		CommentModel comment = FactoryManager.getModelFactory().createModel(CommentModel.class);
		String result = comment.serializeComment();
		assertEquals(
				"{\"name\":\"Comment Name\",\"email\":\"olga@getchute.com\",\"comment_text\":\"This is my comment\"}",
				result);
	}
}
