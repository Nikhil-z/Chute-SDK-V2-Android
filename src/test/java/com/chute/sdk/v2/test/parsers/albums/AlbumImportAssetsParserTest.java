package com.chute.sdk.v2.test.parsers.albums;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;

import junit.framework.TestCase;

public class AlbumImportAssetsParserTest extends TestCase {

	public void testAlbumImportAssetsParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Imported Assets\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/import?urls=[%22http://goo.gl/nK2Fk%22,%22http://goo.gl/LUmND%22]&bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":[{\"id\":521744599,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744599\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744599/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744599/geo\",\"title\":\"Geo Details\"},\"heart\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744599/hearts\",\"title\":\"Heart\"},\"vote\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744599/votes\",\"title\":\"Vote\"}},\"created_at\":\"2013-06-11T11:29:17Z\",\"updated_at\":\"2013-06-11T11:29:17Z\",\"thumbnail\":\"http://media.getchute.com/media/zjbBthklb/75x75\",\"url\":\"http://media.getchute.com/media/zjbBthklb\",\"shortcut\":\"zjbBthklb\",\"type\":\"image\",\"caption\":\"caption\",\"dimensions\":{\"width\":null,\"height\":null},\"location\":\"3135433\",\"source\":{\"source\":\"import\",\"source_id\":null,\"source_url\":\"[\\\"http://goo.gl/nK2Fk\\\"\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}},{\"id\":521744601,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744601\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744601/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744601/geo\",\"title\":\"Geo Details\"},\"heart\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744601/hearts\",\"title\":\"Heart\"},\"vote\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets/521744601/votes\",\"title\":\"Vote\"}},\"created_at\":\"2013-06-11T11:29:17Z\",\"updated_at\":\"2013-06-11T11:29:17Z\",\"thumbnail\":\"http://media.getchute.com/media/zjbBvxpgy/75x75\",\"url\":\"http://media.getchute.com/media/zjbBvxpgy\",\"shortcut\":\"zjbBvxpgy\",\"type\":\"image\",\"caption\":null,\"dimensions\":{\"width\":null,\"height\":null},\"location\":null,\"source\":{\"source\":\"import\",\"source_id\":null,\"source_url\":\"\\\"http://goo.gl/LUmND\\\"]\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}]}";
		ListResponseParser<AssetModel> parser = new ListResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ListResponseModel<AssetModel> response = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			AssetModel asset = response.getData().get(0);
			assertEquals(asset.getId(), "521744599");
			assertNotNull(asset.getLinks());
			assertEquals(asset.getCreatedAt(), "2013-06-11T11:29:17Z");
			assertEquals(asset.getUpdatedAt(), "2013-06-11T11:29:17Z");
			assertEquals(asset.getThumbnail(),
					"http://media.getchute.com/media/zjbBthklb/75x75");
			assertEquals(asset.getUrl(),
					"http://media.getchute.com/media/zjbBthklb");
			assertEquals(asset.getShortcut(), "zjbBthklb");
			assertEquals(asset.getType(), "image");
			assertEquals(asset.getCaption(), "caption");
			assertNotNull(asset.getDimensions());
			assertEquals(asset.getLocation(), "3135433");
			assertNotNull(asset.getSource());
			assertEquals(asset.getService(), "uploaded");
			assertNotNull(asset.getUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
