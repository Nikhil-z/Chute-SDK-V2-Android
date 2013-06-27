package com.chute.sdk.v2.test.parsers.hearts;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.response.ResponseModel;

import junit.framework.TestCase;

public class HeartGetParserTest extends TestCase {

	public void testHeartGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Heart Count\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/364003199/hearts?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"count\":0}}";
		ResponseParser<HeartModel> parser = new ResponseParser<HeartModel>(
				HeartModel.class);
		try {
			ResponseModel<HeartModel> flag = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(flag.getData().getCount());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
