package com.chute.sdk.v2.test.parsers.albums;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;

import junit.framework.TestCase;

public class AlbumImportParserTest extends TestCase {

	public void testAlbumImportParser() {
		String jsonResponse = "";
		String parserResponse = "ListResponseModel [data=[AssetModel [id=500998378, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751/assets/500998378, title=Asset Details], assets=null, exif=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751/assets/500998378/exif, title=Exif Details]], thumbnail=http://media.getchute.com/media/xU8z0jvhu/75x75, url=http://media.getchute.com/media/xU8z0jvhu, type=image, caption=null, dimensions=DimensionsModel [width=0, height=0], source=SourceModel [source=import, sourceId=0, sourceUrl=http://goo.gl/EZICi, service=null, importId=0, importUrl=null, originalUrl=null], user=UserModel [id=726, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/726, title=User Details], assets=null, exif=null], name=ola, username=ola, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], votes=0, hearts=0, tags=null], AssetModel [id=500998379, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751/assets/500998379, title=Asset Details], assets=null, exif=LinkInfoModel [href=http://api.getchute.com/v2/albums/2431751/assets/500998379/exif, title=Exif Details]], thumbnail=http://media.getchute.com/media/xU8z1gkue/75x75, url=http://media.getchute.com/media/xU8z1gkue, type=image, caption=null, dimensions=DimensionsModel [width=0, height=0], source=SourceModel [source=import, sourceId=0, sourceUrl=http://goo.gl/4faY3, service=null, importId=0, importUrl=null, originalUrl=null], user=UserModel [id=726, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/726, title=User Details], assets=null, exif=null], name=ola, username=ola, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], votes=0, hearts=0, tags=null]], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/albums/2431751/assets/import, apiLimits=null]]";
		ListResponseParser<AlbumModel> parser = new ListResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ListResponseModel<AlbumModel> album = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			// assertEquals(album, parserResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
