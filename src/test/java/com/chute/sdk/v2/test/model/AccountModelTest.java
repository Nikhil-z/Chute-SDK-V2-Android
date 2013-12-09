package com.chute.sdk.v2.test.model;

import java.io.IOException;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AccountModelTest extends TestCase {

	String testModel = TestUtil.readResourceAsString("model/AccountModel.json");

	public void testAccountModel() throws JsonParseException,
			JsonMappingException, IOException {
		AccountModel initialModel = JsonUtil.getMapper().readValue(testModel,
				AccountModel.class);
		AccountModel secondModel = AccountModel.fromJSON(initialModel.toJSON());
		assertEquals(initialModel.toJSON(), secondModel.toJSON());
	}

}
