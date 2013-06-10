package com.chute.sdk.v2.test.parsers.parcels;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;

public class ParcelAssetGetParserTest extends TestCase {

	public void testParcelAssetGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Asset Listing\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/parcels/619358/assets?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":[{\"id\":364003199,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/364003199\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/assets/364003199/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/assets/364003199/geo\",\"title\":\"Geo Details\"}},\"created_at\":\"2013-04-08T11:15:06Z\",\"updated_at\":\"2013-04-08T11:15:23Z\",\"thumbnail\":\"http://media.getchute.com/media/oDjRlukgv/75x75\",\"url\":\"http://media.getchute.com/media/oDjRlukgv\",\"shortcut\":\"oDjRlukgv\",\"type\":\"image\",\"caption\":\"caption\",\"dimensions\":{\"width\":null,\"height\":null},\"location\":\"2335351\",\"source\":{\"source\":\"chute\",\"source_id\":null,\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":202,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/202\",\"title\":\"User Details\"}},\"created_at\":\"2011-10-29T11:32:07Z\",\"updated_at\":\"2012-08-27T18:26:00Z\",\"name\":\"Ola La\",\"username\":\"Ola La\",\"avatar\":\"http://graph.facebook.com/531094438/picture?type=square\",\"profile\":{\"First Name\":\"Olga\",\" Last Name\":\"Lazarova\",\" Email\":\"olahla@gmail.com\",\" Phone Number\":\"+38977889533\",\" Birth Year\":\"1983\"}}}],\"pagination\":{\"current_page\":1,\"next_page\":\"https://api.getchute.com/v2/parcels/619358/assets?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e&page=2\",\"previous_page\":null,\"first_page\":\"https://api.getchute.com/v2/parcels/619358/assets?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\",\"per_page\":5}}";
		ListResponseParser<AssetModel> parser = new ListResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ListResponseModel<AssetModel> assets = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			AssetModel asset = assets.getData().get(0);
			assertEquals(asset.getId(), "364003199");
			assertNotNull(asset.getLinks());
			assertEquals(asset.getThumbnail(),
					"http://media.getchute.com/media/oDjRlukgv/75x75");
			assertEquals(asset.getUrl(),
					"http://media.getchute.com/media/oDjRlukgv");
			assertEquals(asset.getType(), "image");
			assertEquals(asset.getCaption(), "caption");
			assertNotNull(asset.getDimensions());
			assertNotNull(asset.getSource());
			assertNotNull(asset.getUser());
			assertEquals(asset.getVotes(), 0);
			assertEquals(asset.getCreatedAt(), "2013-04-08T11:15:06Z");
			assertEquals(asset.getUpdatedAt(), "2013-04-08T11:15:23Z");
			assertEquals(asset.getShortcut(), "oDjRlukgv");
			assertEquals(asset.getLocation(), "2335351");
			assertEquals(asset.getService(), "uploaded");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
