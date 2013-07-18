package com.chute.sdk.v2.api.authentication;




public class AuthConstants {

	public String clientId;
	public String clientSecret;
	public static final String PERMISSIONS_SCOPE = "all_resources manage_resources profile resources";
	public static String CALLBACK_URL = "http://getchute.com/oauth/callback";

	public AuthConstants(String clientId,
			String clientSecret) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	@Override
	public String toString() {
		return "AuthConstants [clientId=" + clientId + ", clientSecret="
				+ clientSecret + "]";
	}
	
	

}