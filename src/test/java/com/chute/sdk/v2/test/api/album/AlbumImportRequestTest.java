package com.chute.sdk.v2.test.api.album;

import junit.framework.TestCase;

import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tobedevoured.modelcitizen.CreateModelException;

public class AlbumImportRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString() throws JsonProcessingException, CreateModelException {
		String[] urls = new String[] { "http://www.getchute.com", "http://www.google.com", "http://www.android.com"};
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("urls").writeValueAsString(urls);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		assertEquals("{\"urls\":[\"http://www.getchute.com\",\"http://www.google.com\",\"http://www.android.com\"]}", result);
	}
}
