package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;

public class AssetListParserTest extends TestCase {

	public void testAssetListParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Asset Listing\",\"warning\":\"Deprecated route: This will be disabled soon. Please include an album in the route to access an asset.\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/assets?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":[{\"id\":450130490,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/450130490\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/assets/450130490/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/assets/450130490/geo\",\"title\":\"Geo Details\"}},\"created_at\":\"2013-05-17T12:43:05Z\",\"updated_at\":\"2013-05-17T12:43:32Z\",\"thumbnail\":\"http://media.getchute.com/media/usHvcdaop/75x75\",\"url\":\"http://media.getchute.com/media/usHvcdaop\",\"shortcut\":\"usHvcdaop\",\"type\":\"image\",\"caption\":null,\"dimensions\":{\"width\":null,\"height\":null},\"location\":null,\"source\":{\"source\":\"chute\",\"source_id\":null,\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/450130490/450130490-usHvcdaop.jpg\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}],\"pagination\":{\"current_page\":1,\"next_page\":\"https://api.getchute.com/v2/assets?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167&page=2\",\"previous_page\":null,\"first_page\":\"https://api.getchute.com/v2/assets?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\",\"per_page\":5}}";
		String parserResponse = "ListResponseModel [data=[AssetModel [id=450130490, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/assets/450130490, title=Asset Details], assets=null, exif=LinkInfoModel [href=http://api.getchute.com/v2/assets/450130490/exif, title=Exif Details]], thumbnail=http://media.getchute.com/media/usHvcdaop/75x75, url=http://media.getchute.com/media/usHvcdaop, type=image, caption=null, dimensions=DimensionsModel [width=0, height=0], source=SourceModel [source=chute, sourceId=0, sourceUrl=http://media.getchute.com.s3.amazonaws.com/assets/images/450130490/450130490-usHvcdaop.jpg, service=null, importId=0, importUrl=null, originalUrl=null], user=UserModel [id=545, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/545, title=User Details], assets=null, exif=null], name=darko1002001, username=darko1002001, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], votes=0, hearts=0, tags=null]], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/assets?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167, apiLimits=null]]";
		ListResponseParser<AssetModel> parser = new ListResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ListResponseModel<AssetModel> model = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(model.toString(), parserResponse);
		} catch (Exception e) {
			fail();
		}
	}
}
