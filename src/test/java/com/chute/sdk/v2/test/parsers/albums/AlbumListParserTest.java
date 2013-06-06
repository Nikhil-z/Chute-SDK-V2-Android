package com.chute.sdk.v2.test.parsers.albums;


import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;

public class AlbumListParserTest extends TestCase {

	public void testAlbumsListParser() {
		String parserResponse = "ListResponseModel [data=[], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/albums?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167, apiLimits=null]]";
		String jsonResponse = "{\"response\":{\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":[],\"pagination\":{\"current_page\":1,\"next_page\":null,\"previous_page\":null,\"first_page\":\"https://api.getchute.com/v2/albums?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\",\"per_page\":5}}";
		ListResponseParser<AlbumModel> parser = new ListResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ListResponseModel<AlbumModel> model = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(model.toString(), parserResponse);
		} catch (Exception e) {
			fail();
		}
	}

}
