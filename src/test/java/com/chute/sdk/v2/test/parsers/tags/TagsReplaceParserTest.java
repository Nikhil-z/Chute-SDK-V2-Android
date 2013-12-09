package com.chute.sdk.v2.test.parsers.tags;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class TagsReplaceParserTest extends TestCase {

	public void testTagsReplaceParser() {

		ListResponseParser<String> parser = new ListResponseParser<String>(
				String.class);
		try {
			ListResponseModel<String> tags = parser.parse(TestUtil.readResourceAsStream("parser/tag/TagUpdate.json"));
			assertNotNull(tags.getData());
		} catch (Exception e) {
			fail();
		}
	}

}
