package com.chute.sdk.v2.model.enums;

public enum AccountType {
  FACEBOOK("facebook"), CHUTE("chute"), TWITTER("twitter"), FOURSQUARE("foursquare"), PICASA(
      "google"), FLICKR(
      "flickr"), INSTAGRAM("instagram"), DROPBOX("dropbox"), GOOGLE("google"), GOOGLEDRIVE(
      "google"), SKYDRIVE("microsoft_account");

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