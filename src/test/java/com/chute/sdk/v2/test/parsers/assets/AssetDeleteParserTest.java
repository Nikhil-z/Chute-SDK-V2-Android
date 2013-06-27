package com.chute.sdk.v2.test.parsers.assets;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class AssetDeleteParserTest extends TestCase {

	public void testAssetDeleteParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Asset Deleted\",\"version\":2,\"code\": 200,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/448049635?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> reponse = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(reponse.getResponse().getTitle());
		} catch (Exception e) {
			fail();
		}
	}

}
