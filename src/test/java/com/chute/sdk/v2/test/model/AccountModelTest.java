package com.chute.sdk.v2.test.model;

import java.io.IOException;

import junit.framework.TestCase;

import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AccountModelTest extends TestCase {

  String testModel = "{\"id\":74,\"created_at\":\"2013-07-08T20:02:50Z\",\"updated_at\":\"2013-07-08T20:02:50Z\",\"shortcut\":\"1cmshj\",\"uid\":\"21818300\",\"type\":\"instagram\",\"name\":\"\",\"username\":\"darko1002001\",\"avatar\":\"http://images.ak.instagram.com/profiles/anonymousUser.jpg\",\"access_key\":\"21818300.655cd71.0257b39de7f347b09b087ee3731589a1\",\"access_secret\":null,\"email\":null}";

  public void testAccountModel() throws JsonParseException, JsonMappingException,
      IOException {
    AccountModel initialModel = JsonUtil.getMapper().readValue(testModel,
        AccountModel.class);
    AccountModel secondModel = AccountModel.fromJSON(initialModel.toJSON());
    assertEquals(initialModel.toJSON(), secondModel.toJSON());
  }

}
