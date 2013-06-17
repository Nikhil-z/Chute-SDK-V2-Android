package com.chute.sdk.v2.test.parsers.comments;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

import junit.framework.TestCase;

public class CommentCreateParserTest extends TestCase {

	public void testCommentCreateParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Comment Details\",\"version\":2,\"code\":201,\"href\":\"https://api.getchute.com/v2/albums/2400518/assets/412178871/comments?[comment][comment_text]=new&bearer_token=d1291c9058c4928e8b403f9418c365e3f233082d7459d3a34f9c61beefac5167\"},\"data\":{\"id\":701,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/comments/701\",\"title\":\"Comment Details\"}},\"created_at\":\"2013-06-10T11:38:37Z\",\"updated_at\":\"2013-06-10T11:38:37Z\",\"comment_text\":\"new\",\"name\":null,\"email\":null,\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}}";

		ResponseParser<CommentModel> parser = new ResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ResponseModel<CommentModel> response = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			CommentModel comment = response.getData();
			assertEquals(comment.getId(), "701");
			assertNotNull(comment.getLinks());
			assertEquals(comment.getCreatedAt(), "2013-06-10T11:38:37Z");
			assertEquals(comment.getUpdatedAt(), "2013-06-10T11:38:37Z");
			assertEquals(comment.getCommentText(), "new");
			assertEquals(comment.getName(), null);
			assertEquals(comment.getEmail(), null);
			assertNotNull(comment.getUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
