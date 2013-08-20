package com.chute.sdk.v2.model.enums;

public enum Service implements ServiceTypeInterface {
  FACEBOOK("facebook", ServiceType.ACCOUNT_TYPE), CHUTE("chute", ServiceType.ACCOUNT_TYPE), TWITTER(
      "twitter", ServiceType.ACCOUNT_TYPE), FOURSQUARE("foursquare",
      ServiceType.ACCOUNT_TYPE), PICASA(
      "google", ServiceType.ACCOUNT_TYPE), FLICKR(
      "flickr", ServiceType.ACCOUNT_TYPE), INSTAGRAM("instagram",
      ServiceType.ACCOUNT_TYPE), DROPBOX("dropbox", ServiceType.ACCOUNT_TYPE), GOOGLE_PLUS(
      "google", ServiceType.ACCOUNT_TYPE), GOOGLE_DRIVE(
      "google", ServiceType.ACCOUNT_TYPE), SKYDRIVE("skydrive", ServiceType.ACCOUNT_TYPE), CAMERA_SHOTS(
      "camera shots", ServiceType.LOCAL_MEDIA_TYPE), ALL_PHOTOS(
      "all photos", ServiceType.LOCAL_MEDIA_TYPE), LAST_PHOTO_TAKEN("last photo taken",
      ServiceType.LOCAL_MEDIA_TYPE), TAKE_PHOTO(
      "take photo", ServiceType.LOCAL_MEDIA_TYPE);

  private final String label;
  private final ServiceType type;

  private Service(String label, ServiceType type) {
    this.label = label;
    this.type = type;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String getDisplayableType() {
    return type.getDisplayableType();
  }

}
