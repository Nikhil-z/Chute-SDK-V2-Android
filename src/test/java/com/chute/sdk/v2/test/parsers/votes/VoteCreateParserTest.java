package com.chute.sdk.v2.test.parsers.votes;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class VoteCreateParserTest extends TestCase {

	public void testVoteCreateParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Vote Details\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/339719449/votes?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"id\":205,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/votes/205\",\"title\":\"Vote Details\"}},\"created_at\":\"2013-06-10T10:43:10Z\",\"updated_at\":\"2013-06-10T10:43:10Z\",\"identifier\":\"jxaztbktyrcfcuveofjm1370860990\",\"album_id\":2399241,\"asset_id\":339719449}}";
		ResponseParser<VoteModel> parser = new ResponseParser<VoteModel>(
				VoteModel.class);
		try {
			ResponseModel<VoteModel> response = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			VoteModel vote = response.getData();
			assertEquals(vote.getId(), "205");
			assertNotNull(vote.getLinks());
			assertEquals(vote.getCreatedAt(), "2013-06-10T10:43:10Z");
			assertEquals(vote.getUpdatedAt(), "2013-06-10T10:43:10Z");
			assertEquals(vote.getIdentifier(), "jxaztbktyrcfcuveofjm1370860990");
			assertEquals(vote.getAlbumId(), "2399241");
			assertEquals(vote.getAssetId(), "339719449");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
