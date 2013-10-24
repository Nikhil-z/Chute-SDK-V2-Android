package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class AlbumGetParserTest extends TestCase {

	public void testAlbumsGetParser() {
		String jsonResponse = "{\"response\":{\"title\":\"Album Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400518?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":2483091,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2483091\",\"title\":\"Album Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/albums/2483091/assets\",\"title\":\"Asset Listing\"},\"parcels\":{\"href\":\"http://api.getchute.com/v2/albums/2483091/parcels\",\"title\":\"Parcel Listing\"}},\"created_at\":\"2013-10-22T12:02:10Z\",\"updated_at\":\"2013-10-22T12:02:10Z\",\"shortcut\":\"apXRuelq\",\"name\":\"testing cover asset\",\"description\":null,\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null},\"moderate_media\":false,\"moderate_comments\":false,\"parent_id\":null,\"cover_asset\":{\"id\":648689795,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/648689795\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/assets/648689795/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/assets/648689795/geo\",\"title\":\"Geo Details\"}},\"created_at\":\"2011-02-18T03:06:07Z\",\"updated_at\":\"2013-09-09T02:12:10Z\",\"thumbnail\":\"http://distillery.s3.amazonaws.com/media/2011/02/17/a3f1308a99784d0c93627373f886b0c1_5.jpg\",\"url\":\"http://media.getchute.com/media/HTPQDotqk\",\"shortcut\":\"HTPQDotqk\",\"type\":\"image\",\"caption\":\"#slovenia #skopje #latvia #turkey #istambul #china #beijing #poland #warsaw #lisbon #portugal #dublin #ireland #eire #northernireland #sweden #stockholm #russia #moscow #estonia #tallinn\",\"dimensions\":{\"width\":612,\"height\":612},\"location\":null,\"source\":{\"source\":\"import\",\"source_id\":\"28030172_2058503\",\"source_url\":\"http://distillery.s3.amazonaws.com/media/2011/02/17/a3f1308a99784d0c93627373f886b0c1_7.jpg\",\"service\":\"instagram\",\"import_id\":\"28030172_2058503\",\"import_url\":\"http://instagram.com/p/Bq7Tc/\"},\"service\":\"instagram\",\"username\":\"andrefabiano\"}}}";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> album = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(album.getData().getName());
			assertNotNull(album.getData().getCreatedAt());
			assertNotNull(album.getData().getLinks());
			assertNotNull(album.getData().getUser());
			assertNotNull(album.getData().getCoverAsset());
		} catch (Exception e) {
			fail();
		}
	}
}
