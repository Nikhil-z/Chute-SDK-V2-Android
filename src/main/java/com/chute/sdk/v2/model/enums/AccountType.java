package com.chute.sdk.v2.model.enums;

public enum AccountType {
	FACEBOOK("facebook"), CHUTE("chute"), TWITTER("twitter"), FOURSQUARE("foursquare"), PICASA("google"), FLICKR(
			"flickr"), INSTAGRAM("instagram"), DROPBOX("dropbox"), GOOGLEDRIVE("googledrive"), SKYDRIVE("skydrive");

	private final String name;

	private AccountType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	};

	public String getName() {
		return name;
	}
}