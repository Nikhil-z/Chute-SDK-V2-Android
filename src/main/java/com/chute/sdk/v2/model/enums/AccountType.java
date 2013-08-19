package com.chute.sdk.v2.model.enums;

public enum AccountType {
	FACEBOOK("facebook"), CHUTE("chute"), TWITTER("twitter"), FOURSQUARE("foursquare"), PICASA("google"), FLICKR(
			"flickr"), INSTAGRAM("instagram"), DROPBOX("dropbox"),GOOGLE_PLUS("google"), GOOGLE_DRIVE("google"), SKYDRIVE("skydrive");

	private final String loginMethod;

	private AccountType(String loginMethod) {
		this.loginMethod = loginMethod;
	}

	@Override
	public String toString() {
		return loginMethod;
	};
	
    public String getLoginMethod() {
      return loginMethod;
    }
}