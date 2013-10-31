package com.chute.sdk.v2.api.authentication;


public class AuthenticationOptions {

  boolean clearCookiesForAccount;
  boolean shouldRetainSession;

  private AuthenticationOptions(AuthenticationOptions.Builder builder) {
    super();
    this.clearCookiesForAccount = builder.clearCookiesForAccount;
    this.shouldRetainSession = builder.shouldRetainSession;
  }

  public static class Builder {

    boolean clearCookiesForAccount = false;
    boolean shouldRetainSession = true;
    
    public Builder() {
      super();
    }

    public Builder setClearCookiesForAccount(boolean clearCookiesForAccount) {
      this.clearCookiesForAccount = clearCookiesForAccount;
      return this;
    }

    public Builder setShouldRetainSession(boolean shouldRetainSession) {
      this.shouldRetainSession = shouldRetainSession;
      return this;
    }

    public AuthenticationOptions build() {
      return new AuthenticationOptions(this);
    }

  }
}