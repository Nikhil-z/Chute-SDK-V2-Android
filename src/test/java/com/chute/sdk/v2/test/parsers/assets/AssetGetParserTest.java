package com.chute.sdk.v2.test.parsers.assets;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class AssetGetParserTest extends TestCase {

	public void testAssetGetParser() {

		String parserResponse = "ResponseModel [data=AssetModel [id=448080848, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/assets/448080848, title=Asset Details], assets=null, exif=LinkInfoModel [href=http://api.getchute.com/v2/assets/448080848/exif, title=Exif Details]], thumbnail=http://media.getchute.com/media/uk6issply/75x75, url=http://media.getchute.com/media/uk6issply, type=image, caption=null, dimensions=DimensionsModel [width=0, height=0], source=SourceModel [source=chute, sourceId=0, sourceUrl=http://media.getchute.com.s3.amazonaws.com/assets/images/448080848/448080848-uk6issply.jpg, service=null, importId=0, importUrl=null, originalUrl=null], user=UserModel [id=545, links=LinkModel [self=LinkInfoModel [href=http://api.getchute.com/v2/users/545, title=User Details], assets=null, exif=null], name=darko1002001, username=darko1002001, avatar=http://static.getchute.com/v1/images/avatar-100x100.png], votes=0, hearts=0, tags=null], pagination=null, response=ResponseStatusModel [error=null, version=2, code=200, href=https://api.getchute.com/v2/assets/448080848?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167, apiLimits=null]]";
		String jsonResponse = "{\"response\":{\"title\":\"Asset Details\",\"warning\":\"Deprecated route: This will be disabled soon. Please include an album in the route to access an asset.\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/assets/448080848?bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":448080848,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/assets/448080848\",\"title\":\"Asset Details\"},\"exif\":{\"href\":\"http://api.getchute.com/v2/assets/448080848/exif\",\"title\":\"Exif Details\"},\"geo\":{\"href\":\"http://api.getchute.com/v2/assets/448080848/geo\",\"title\":\"Geo Details\"}},\"created_at\":\"2013-05-16T14:59:46Z\",\"updated_at\":\"2013-05-16T14:59:59Z\",\"thumbnail\":\"http://media.getchute.com/media/uk6issply/75x75\",\"url\":\"http://media.getchute.com/media/uk6issply\",\"shortcut\":\"uk6issply\",\"type\":\"image\",\"caption\":null,\"dimensions\":{\"width\":null,\"height\":null},\"location\":null,\"source\":{\"source\":\"chute\",\"source_id\":null,\"source_url\":\"http://media.getchute.com.s3.amazonaws.com/assets/images/448080848/448080848-uk6issply.jpg\",\"service\":null,\"import_id\":null,\"import_url\":null},\"service\":\"uploaded\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}}";
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> model = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertEquals(model.toString(), parserResponse);
		} catch (Exception e) {
			fail();
		}
	}

}
