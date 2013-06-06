package com.chute.sdk.v2.test.parsers.assets;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class AssetExifParserTest extends TestCase {

	public void testAssetExifParser() {

		String parserResponse = "ResponseModel [data=AssetModel [id=null, links=null, thumbnail=null, url=null, type=null, caption=null, dimensions=null, source=null, user=null, votes=0, hearts=0, tags=null], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/assets/448080848/exif?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167, apiLimits=null]]";
		String jsonResponse = "{\"response\":{\"title\":\"Exif Details\",\"warning\":\"Deprecated route: This will be disabled soon. Please include an album in the route to access an asset.\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/assets/448080848/exif?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> model = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(model.toString(), parserResponse);
		} catch (Exception e) {
			fail();
		}
	}

}
