package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class AlbumDeleteParserTest extends TestCase {

	public void testAlbumDeleteParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Album Deleted\",\"version\": 2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400517?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"}}";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> reponse = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(reponse.getResponse().getTitle());
		} catch (Exception e) {
			fail();
		}
	}

}
