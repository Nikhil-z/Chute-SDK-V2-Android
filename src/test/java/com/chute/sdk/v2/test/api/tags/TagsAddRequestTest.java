package com.chute.sdk.v2.test.api.tags;

import junit.framework.TestCase;

import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TagsAddRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString() {
		String[] tags = new String[] { "chute", "office", "HQ" };
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("tags")
					.writeValueAsString(tags);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		assertEquals("{\"tags\":[\"chute\",\"office\",\"HQ\"]}", result);
	}
}
