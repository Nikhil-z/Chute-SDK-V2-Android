package com.chute.sdk.v2.test.parsers.flags;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.response.ResponseModel;

import junit.framework.TestCase;

public class FlagCreateParserTest extends TestCase {

	public void testFlagCreateParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Flag Details\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/339719449/flags?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"id\":110,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/flags/110\",\"title\":\"Flag Details\"}},\"created_at\":\"2013-06-10T10:30:51Z\",\"updated_at\":\"2013-06-10T10:30:51Z\",\"identifier\":\"pmlemhvntjrekemazdem1370860251\",\"album_id\":2399241,\"asset_id\":339719449}}";
		ResponseParser<FlagModel> parser = new ResponseParser<FlagModel>(
				FlagModel.class);
		try {
			ResponseModel<FlagModel> response = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			FlagModel flag = response.getData();
			assertEquals(flag.getId(), "110");
			assertNotNull(flag.getLinks());
			assertEquals(flag.getCreatedAt(), "2013-06-10T10:30:51Z");
			assertEquals(flag.getUpdatedAt(), "2013-06-10T10:30:51Z");
			assertEquals(flag.getIdentifier(), "pmlemhvntjrekemazdem1370860251");
			assertEquals(flag.getAlbumId(), "2399241");
			assertEquals(flag.getAssetId(), "339719449");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
