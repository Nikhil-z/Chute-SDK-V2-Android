package com.chute.sdk.v2.test.parsers.comments;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;

public class CommentListParserTest extends TestCase {

	public void testCommentListParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Comment Listing\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2399241/assets/364003199/comments?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":[{\"id\":700,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/comments/700\",\"title\":\"Comment Details\"}},\"created_at\":\"2013-05-21T15:15:28Z\",\"updated_at\":\"2013-05-21T15:15:28Z\",\"comment_text\":\"hey\",\"name\":\"commentname\",\"email\":\"olga@getchute.com\",\"user\":{\"id\":545,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/users/545\",\"title\":\"User Details\"}},\"created_at\":\"2012-01-17T19:53:39Z\",\"updated_at\":\"2012-09-15T10:55:51Z\",\"name\":\"darko1002001\",\"username\":\"darko1002001\",\"avatar\":\"http://static.getchute.com/v1/images/avatar-100x100.png\",\"profile\":null}}],\"pagination\":{\"current_page\":1,\"next_page\":null,\"previous_page\":null,\"first_page\":\"https://api.getchute.com/v2/albums/2399241/assets/364003199/comments?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\",\"per_page\":5}}";
		ListResponseParser<CommentModel> parser = new ListResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ListResponseModel<CommentModel> commentList = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			CommentModel comment = commentList.getData().get(0);
			assertEquals(comment.getId(), "700");
			assertNotNull(comment.getLinks());
			assertEquals(comment.getCreatedAt(), "2013-05-21T15:15:28Z");
			assertEquals(comment.getUpdatedAt(), "2013-05-21T15:15:28Z");
			assertEquals(comment.getCommentText(), "hey");
			assertEquals(comment.getName(), "commentname");
			assertEquals(comment.getEmail(), "olga@getchute.com");
			assertNotNull(comment.getUser());
		} catch (Exception e) {
			fail();
		}
	}

}
