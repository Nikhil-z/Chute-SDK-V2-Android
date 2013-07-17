package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class AssetExifParserTest extends TestCase {

	public void testAssetExifParser() {

		//deprecated
		String jsonResponse = "{\"response\":{\"title\":\"Exif Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/448080848/exif?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> asset = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(asset.getData());
		} catch (Exception e) {
			fail();
		}
	}

}
