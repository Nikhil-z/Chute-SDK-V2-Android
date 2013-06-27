package com.chute.sdk.v2.test.parsers.tags;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.response.ListResponseModel;

import junit.framework.TestCase;

public class TagsReplaceParserTest extends TestCase {

	public void testTagsReplaceParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Tags Updated\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/412178871/tags?[tag][tags]=[%22polution%22,%22tree%22]&bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":[\"[\\\"polution\\\"\",\"\\\"tree\\\"]\"]}";
		ListResponseParser<String> parser = new ListResponseParser<String>(
				String.class);
		try {
			ListResponseModel<String> tags = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(tags.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
