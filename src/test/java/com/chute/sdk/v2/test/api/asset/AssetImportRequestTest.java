package com.chute.sdk.v2.test.api.asset;

import junit.framework.TestCase;

import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tobedevoured.modelcitizen.CreateModelException;

public class AssetImportRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
			throws JsonProcessingException, CreateModelException {
		String[] urls = new String[] { "http://goo.gl/gLeZX",
				"http://goo.gl/qFaiz" };
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("urls")
					.writeValueAsString(urls);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		String expected = TestUtil
				.readResourceAsString("request/AssetImport.json");
		assertEquals(expected, result);
	}
}
