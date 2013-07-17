package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class AlbumCreateParserTest extends TestCase {

	public void testAlbumCreateParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Album Details\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums?[album][name]=new&bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":2435024,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2435024\",\"title\":\"Album Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/albums/2435024/assets\",\"title\":\"Asset Listing\"},\"parcels\":{\"href\":\"http://api.getchute.com/v2/albums/2435024/parcels\",\"title\":\"Parcel Listing\"}},\"created_at\":\"2013-06-10T11:47:25Z\",\"updated_at\":\"2013-06-10T11:47:25Z\",\"shortcut\":\"adsAiazc\",\"name\":\"new\",\"description\":null,\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null},\"moderate_media\":false,\"moderate_comments\":false,\"parent_id\":null}}";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> album = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(album.getData().getId(), "2435024");
			assertNotNull(album.getData().getLinks());
			assertEquals(album.getData().getCreatedAt(), "2013-06-10T11:47:25Z");
			assertEquals(album.getData().getUpdatedAt(), "2013-06-10T11:47:25Z");
			assertEquals(album.getData().getShortcut(), "adsAiazc");
			assertEquals(album.getData().getName(), "new");
			assertEquals(album.getData().getDescription(), null);
			assertNotNull(album.getData().getUser());
			assertEquals(album.getData().isModerateMedia(), false);
			assertEquals(album.getData().isModerateComments(), false);
			assertEquals(album.getData().getParentId(), null);
		} catch (Exception e) {
			fail();
		}
	}

}
