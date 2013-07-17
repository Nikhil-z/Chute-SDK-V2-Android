package com.chute.sdk.v2.test.parsers.comments;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ResponseModel;

public class CommentDeleteParserTest extends TestCase {

	public void testCommentDeleteParser() {
		String jsonResponse = "{\"response\":{\"title\":\"Comment Deleted\",\"version\":2,\"code\": 200,\"href\":\"https://api.getchute.com/v2/comments/700?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"}}";
		ResponseParser<CommentModel> parser = new ResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ResponseModel<CommentModel> comment = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			assertNotNull(comment.getResponse().getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
