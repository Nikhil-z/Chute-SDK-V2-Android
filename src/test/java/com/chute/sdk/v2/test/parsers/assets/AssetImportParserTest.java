package com.chute.sdk.v2.test.parsers.assets;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class AssetImportParserTest extends TestCase {

	public void testAssetImportParser() {

		String jsonResponse = "";
		String parserResponse = "";
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
