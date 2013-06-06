package com.chute.sdk.v2.test.parsers.albums;

import java.io.ByteArrayInputStream;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class AlbumDeleteParserTest extends TestCase {

	public void testAlbumDeleteParser() {
		String response = "ResponseModel [data=null, pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/assets/2431751, apiLimits=null]]";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> model = parser
					.parse(new ByteArrayInputStream(response.getBytes()));
			assertEquals(model, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
}
