package com.chute.sdk.v2.test.parsers.hearts;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class HeartCreateParserTest extends TestCase {
	
	public void testHeartCreateParser() {
		
		String jsonResponse = "{\"response\":{\"title\":\"Heart Details\",\"version\":2,\"code\":201,\"href\": \"https://api.getchute.com/v2/albums/2399241/assets/339719449/hearts?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"id\":616007,\"links\":{\"href\":\"http://api.getchute.com/v2/hearts/alfogpyvgwesdchjekvs1370859588\",\"title\":\"Heart Details\"},\"created_at\":\"2013-06-10T10:19:48Z\",\"updated_at\":\"2013-06-10T10:19:48Z\",\"identifier\":\"alfogpyvgwesdchjekvs1370859588\",\"album_id\":2399241,\",\"asset_id\":339719449}}";
		ResponseParser<HeartModel> parser = new ResponseParser<HeartModel>(HeartModel.class);
		try {
			ResponseModel<HeartModel> response = parser.parse(IOUtils.toInputStream(jsonResponse));
			HeartModel heart = response.getData();
			assertEquals(heart.getId(), "616007");
			assertNotNull(heart.getLinks());
			assertEquals(heart.getCreatedAt(), "2013-06-10T10:19:48Z");
			assertEquals(heart.getUpdatedAt(), "2013-06-10T10:19:48Z");
			assertEquals(heart.getIdentifier(), "alfogpyvgwesdchjekvs1370859588");
			assertEquals(heart.getAlbumId(), "2399241");
			assertEquals(heart.getAssetId(), "339719449");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
