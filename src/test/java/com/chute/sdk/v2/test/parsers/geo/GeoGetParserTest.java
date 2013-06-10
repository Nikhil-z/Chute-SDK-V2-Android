package com.chute.sdk.v2.test.parsers.geo;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class GeoGetParserTest extends TestCase {

	public void testGeoGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Geo Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/364003199/geo?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{}}";
		ResponseParser<GeoLocationModel> parser = new ResponseParser<GeoLocationModel>(
				GeoLocationModel.class);
		try {
			ResponseModel<GeoLocationModel> geo = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(geo.getData());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
