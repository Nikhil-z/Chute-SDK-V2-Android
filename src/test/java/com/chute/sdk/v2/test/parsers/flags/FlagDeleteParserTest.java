package com.chute.sdk.v2.test.parsers.flags;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.response.ResponseModel;

import junit.framework.TestCase;

public class FlagDeleteParserTest extends TestCase {

	public void testFlagDeleteParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Flag Removed\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/339719449/flags?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"}}";
		ResponseParser<FlagModel> parser = new ResponseParser<FlagModel>(
				FlagModel.class);
		try {
			ResponseModel<FlagModel> flag = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(flag.getResponse().getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
