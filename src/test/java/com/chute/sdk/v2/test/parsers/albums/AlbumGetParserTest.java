package com.chute.sdk.v2.test.parsers.albums;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class AlbumGetParserTest extends TestCase {

	public void testAlbumsGetParser() {
		String parserResponse = "ResponseModel [data=AlbumModel [id=2400518, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/albums/2400518, title=Album Details], assets=LinkInfoModel [href=http://api.getchute.com/v2/albums/2400518/assets, title=Asset Listing], exif=null], counters=null, shortcut=a4u2dyif, name=Environment, user=UserModel [id=545, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/545, title=User Details], assets=null, exif=null], name=darko1002001, username=darko1002001, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], moderateMedia=false, moderateComments=false, createdAt=2013-03-27T12:03:35Z, updatedAt=2013-05-16T14:59:59Z, description=null], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/albums/2400518?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167, apiLimits=null]]";
		String jsonResponse = "{\"response\":{\"title\":\"Album Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2400518?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":2400518,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/albums/2400518\",\"title\":\"Album Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/assets\",\"title\":\"Asset Listing\"},\"parcels\":{\"href\":\"http://api.getchute.com/v2/albums/2400518/parcels\",\"title\":\"Parcel Listing\"}},\"created_at\":\"2013-03-27T12:03:35Z\",\"updated_at\":\"2013-05-16T14:59:59Z\",\"shortcut\":\"a4u2dyif\",\"name\":\"Environment\",\"description\":null,\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null},\"moderate_media\":false,\"moderate_comments\":false,\"parent_id\":null}}";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> model = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(model.toString(), parserResponse);
		} catch (Exception e) {
			fail();
		}
	}
}
