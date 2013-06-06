package com.chute.sdk.v2.test.utils;

import com.chute.sdk.v2.utils.Constants;

import junit.framework.TestCase;

public class ConstantsTest extends TestCase{

	public void testCurrentUserId() {
		assertEquals(Constants.CURRENT_USER_ID, "me");
	}
}
