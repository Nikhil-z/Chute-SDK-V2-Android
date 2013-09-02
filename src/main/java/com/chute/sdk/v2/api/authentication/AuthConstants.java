package com.chute.sdk.v2.api.authentication;

public class AuthConstants {

  public String clientId;
  public static final String PERMISSIONS_SCOPE = "";
  public static String CALLBACK_URL = "http://getchute.com/oauth/callback";

  public String clientSecret;

  public AuthConstants(String clientId, String clientSecret) {
    super();
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

}