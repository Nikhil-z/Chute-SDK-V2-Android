package com.chute.sdk.v2.test.parsers.users;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.UserModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class UserCurrentParserTest extends TestCase {

	public void testUserCurrentParser() {

		String jsonResponse = "{\"response\":{\"title\":\"User Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/me?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null,\"email\":\"darko@getchute.com\",\"oauth_token\":\"f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"}}";
		ResponseParser<UserModel> parser = new ResponseParser<UserModel>(
				UserModel.class);
		try {
			ResponseModel<UserModel> user = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(user.getData().getId(), "545");
			assertNotNull(user.getData().getLinks());
			assertEquals(user.getData().getName(), "darko1002001");
			assertEquals(user.getData().getUsername(), "darko1002001");
			assertEquals(user.getData().getAvatar(), "http://static.getchute.com/v1/images/avatar-100x100.png");
			assertEquals(user.getData().getCreated_at(), "2012-01-17T19:53:39Z");
			assertEquals(user.getData().getUpdated_at(), "2012-09-15T10:55:51Z");
			assertEquals(user.getData().getEmail(), "darko@getchute.com");
			assertEquals(user.getData().getOauthToken(), "f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
