package com.chute.sdk.v2.test.parsers.assets;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

@Deprecated
public class AssetUpdateParserTest extends TestCase {

	public void testAssetUpdateParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Asset Details\",\"warning\":\"Deprecated route: This will be disabled soon. Please include an album in the route to access an asset.\",\"version\":2,\"code\":200,\"href\": \"https://api.getchute.com/v2/assets/412196461?json={%22name%22:%22newname%22}&bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":412196461,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/412196461\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/assets/412196461/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/assets/412196461/geo\",\"title\":\"Geo Details\"}},\"created_at\":\"2013-04-29T10:34:41Z\",\"updated_at\":\"2013-06-10T14:31:36Z\",\"thumbnail\":\"http://media.getchute.com/media/rTx81gnde/75x75\",\"url\":\"http://media.getchute.com/media/rTx81gnde\",\"shortcut\":\"rTx81gnde\",\"type\":\"image\",\"caption\":\"caption\",\"dimensions\":{\"width\": null,\"height\":null},\"location\":\"314343\",\"source\":{\"source\":\"chute\",\"source_id\":null,\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/412196461/412196461-rTx81gnde.jpg\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> asset = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(asset.getData().getId(), "412196461");
			assertEquals(asset.getData().getThumbnail(),
					"http://media.getchute.com/media/rTx81gnde/75x75");
			assertEquals(asset.getData().getUrl(),
					"http://media.getchute.com/media/rTx81gnde");
			assertEquals(asset.getData().getType(), "image");
			assertEquals(asset.getData().getCaption(), "caption");
			assertNotNull(asset.getData().getDimensions());
			assertNotNull(asset.getData().getSource());
			assertNotNull(asset.getData().getUser());
			assertEquals(asset.getData().getCreatedAt(), "2013-04-29T10:34:41Z");
			assertEquals(asset.getData().getUpdatedAt(), "2013-06-10T14:31:36Z");
			assertEquals(asset.getData().getShortcut(), "rTx81gnde");
			assertEquals(asset.getData().getLocation(), "314343");
			assertEquals(asset.getData().getService(), "uploaded");
		} catch (Exception e) {
			fail();
		}
	}

}
