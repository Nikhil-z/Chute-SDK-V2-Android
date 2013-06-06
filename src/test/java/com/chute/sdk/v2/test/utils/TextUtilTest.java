package com.chute.sdk.v2.test.utils;

import com.chute.sdk.v2.utils.TextUtil;

import junit.framework.TestCase;

public class TextUtilTest extends TestCase{

	public void testTruncate() {
		String toTest = "123456789";
		String result = TextUtil.truncate(toTest, 3);
		assertEquals(result.length(), 6);
		assertTrue(result.endsWith("..."));
	}
}
