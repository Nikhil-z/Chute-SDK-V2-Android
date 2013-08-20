package com.chute.sdk.v2.model.enums;

public enum ServiceType implements ServiceTypeInterface {
  LOCAL_MEDIA_TYPE("Local"), ACCOUNT_TYPE("Account");

  private final String type;

  private ServiceType(final String type) {
    this.type = type;
  }

  @Override
  public String getDisplayableType() {
    return type;
  }

}
