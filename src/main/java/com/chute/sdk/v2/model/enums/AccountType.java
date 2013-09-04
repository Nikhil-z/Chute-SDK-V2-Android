package com.chute.sdk.v2.model.enums;

/**
 * Values describing types of account.
 * <p>
 * Every ENUM value contains login method name in the constructor used for
 * authentication.
 * 
 */
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