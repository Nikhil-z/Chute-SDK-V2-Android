package com.chute.sdk.v2.test.parsers.tags;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.response.ListResponseModel;

public class TagsListParserTest extends TestCase {

	public void testTagsListParser() {

		String response = "{\"response\":{\"title\":\"Tags List\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/364003199/tags?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":[]}";
		ListResponseParser<String> parser = new ListResponseParser<String>(
				String.class);
		try {
			ListResponseModel<String> tags = parser.parse(IOUtils
					.toInputStream(response));
			assertNotNull(tags.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
