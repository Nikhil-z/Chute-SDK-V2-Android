package com.chute.sdk.v2.test.parsers.albums;


import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class AlbumCreateParserTest extends TestCase {

	public void testAlbumCreateParser() {

		String jsonResponse = "";
		String parserResponse = "ResponseModel [data=AlbumModel [id=2431751, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751, title=Album Details], assets=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751/assets, title=Asset Listing], exif=null], counters=null, shortcut=acBNsdxk, name=new album, user=UserModel [id=726, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/726, title=User Details], assets=null, exif=null], name=ola, username=ola, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], moderateMedia=false, moderateComments=false, createdAt=2013-06-04T12:07:07Z, updatedAt=2013-06-04T12:07:07Z, description=null], pagination=null, response=ResponseStatusModel [error=null, version=2, code=201, href=https://api.getchute.com/v2/albums, apiLimits=null]]";
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> model = parser
					.parse(IOUtils.toInputStream(jsonResponse));
//			assertEquals(model, parserResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
}
