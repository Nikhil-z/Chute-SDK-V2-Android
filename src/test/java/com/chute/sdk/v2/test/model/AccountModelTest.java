package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import junit.framework.TestCase;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;

public class AccountModelTest extends TestCase {

	String testModel = TestUtil.readResourceAsString("model/AccountModel.json");

	public void testAccountModel() throws JsonParseException,
      JsonMappingException, IOException, JSONException {
		AccountModel initialModel = JsonUtil.getMapper().readValue(testModel,
				AccountModel.class);
		AccountModel secondModel = AccountModel.fromJSON(initialModel.toJSON());
    JSONAssert.assertEquals(initialModel.toJSON(), secondModel.toJSON(), false);

  }

}
