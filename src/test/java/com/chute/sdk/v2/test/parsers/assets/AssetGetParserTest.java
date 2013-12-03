package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class AssetGetParserTest extends TestCase {

	public void testAssetGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Asset Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/448080848?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":448080848,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/448080848\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/448080848/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/448080848/geo\",\"title\":\"Geo Details\"},\"heart\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/448080848/hearts\",\"title\":\"Heart\"},\"vote\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/448080848/votes\",\"title\":\"Vote\"}},\"created_at\":\"2013-05-16T14:59:46Z\",\"updated_at\":\"2013-05-16T14:59:59Z\",\"thumbnail\":\"http://media.getchute.com/m/uk6issply/c/2400518/75x75\",\"url\":\"http://media.getchute.com/m/uk6issply/c/2400518\",\"shortcut\":\"uk6issply\",\"type\":\"image\",\"caption\":\"caption\",\"dimensions\":{\"width\":null,\"height\":null},\"location\":{\"latitude\":\"3\",\"longitude\":\"314343\"},\"source\":{\"source\":\"chute\",\"source_id\":null,\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/448080848/448080848-uk6issply.jpg\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null},\"votes\":0,\"hearts\":0,\"tags\":[],\"chute_asset_id\":\"714958192\"}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> asset = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(asset.getData().getId(), "448080848");
			assertEquals(asset.getData().getThumbnail(),
					"http://media.getchute.com/m/uk6issply/c/2400518/75x75");
			assertEquals(asset.getData().getUrl(),
					"http://media.getchute.com/m/uk6issply/c/2400518");
			assertEquals(asset.getData().getType(), "image");
			assertEquals(asset.getData().getCaption(), "caption");
			assertNotNull(asset.getData().getDimensions());
			assertNotNull(asset.getData().getSource());
			assertNotNull(asset.getData().getUser());
			assertEquals(asset.getData().getVotes(), 0);
			assertNotNull(asset.getData().getTags());
			assertEquals(asset.getData().getHearts(), 0);
			assertEquals(asset.getData().getCreatedAt(), "2013-05-16T14:59:46Z");
			assertEquals(asset.getData().getUpdatedAt(), "2013-05-16T14:59:59Z");
			assertEquals(asset.getData().getShortcut(), "uk6issply");
			assertNotNull(asset.getData().getLocation());
			assertEquals(asset.getData().getService(), "uploaded");
			assertEquals(asset.getData().getChuteAssetId(), "714958192");
		} catch (Exception e) {
			fail();
		}
	}

}
