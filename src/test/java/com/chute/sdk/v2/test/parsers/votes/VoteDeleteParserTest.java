package com.chute.sdk.v2.test.parsers.votes;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class VoteDeleteParserTest extends TestCase {

	public void testVoteDeleteParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Heart Deleted\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/339719449/hearts?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"}}";
		ResponseParser<VoteModel> parser = new ResponseParser<VoteModel>(
				VoteModel.class);
		try {
			ResponseModel<VoteModel> vote = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(vote.getResponse().getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
