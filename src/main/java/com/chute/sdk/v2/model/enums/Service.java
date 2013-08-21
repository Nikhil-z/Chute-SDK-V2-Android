package com.chute.sdk.v2.model.enums;

public enum Service implements ServiceTypeInterface {
  FACEBOOK("facebook", ServiceType.ACCOUNT_TYPE, "facebook"), CHUTE("chute",
      ServiceType.ACCOUNT_TYPE, "chute"), TWITTER(
      "twitter", ServiceType.ACCOUNT_TYPE, "twitter"), FOURSQUARE("foursquare",
      ServiceType.ACCOUNT_TYPE, "foursquare"), PICASA(
      "google", ServiceType.ACCOUNT_TYPE, "picasa"), FLICKR(
      "flickr", ServiceType.ACCOUNT_TYPE, "flickr"), INSTAGRAM("instagram",
      ServiceType.ACCOUNT_TYPE, "instagram"), DROPBOX("dropbox",
      ServiceType.ACCOUNT_TYPE, "dropbox"), GOOGLE_PLUS(
      "google", ServiceType.ACCOUNT_TYPE, "google_plus"), GOOGLE_DRIVE(
      "google", ServiceType.ACCOUNT_TYPE, "google_drive"), SKYDRIVE("skydrive",
      ServiceType.ACCOUNT_TYPE, "skydrive"), CAMERA_SHOTS(
      "camera shots", ServiceType.LOCAL_MEDIA_TYPE, "camera shots"), ALL_PHOTOS(
      "all photos", ServiceType.LOCAL_MEDIA_TYPE, "all photos"), LAST_PHOTO_TAKEN(
      "last photo taken",
      ServiceType.LOCAL_MEDIA_TYPE, "last photo taken"), TAKE_PHOTO(
      "take photo", ServiceType.LOCAL_MEDIA_TYPE, "take photo");

  private final String label;
  private final ServiceType type;
  private final String loginMethod;

  private Service(String loginMethod, ServiceType type, String label) {
    this.label = label;
    this.type = type;
    this.loginMethod = loginMethod;
  }

  public String getLabel() {
    return label;
  }

  public String getLoginMethod() {
    return loginMethod;
  }

  @Override
  public String getDisplayableType() {
    return type.getDisplayableType();
  }

}
