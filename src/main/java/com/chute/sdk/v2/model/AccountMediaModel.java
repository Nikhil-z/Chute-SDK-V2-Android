package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.chute.sdk.v2.model.enums.AccountMediaType;
import com.chute.sdk.v2.model.interfaces.AccountMedia;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link AccountMediaModel} class represents the concept of a media item
 * for a specific object that belongs to an account. Each media item contains
 * URL, thumbnail URL and large image URL.
 * 
 */
public class AccountMediaModel implements Parcelable, AccountMedia {

  @SuppressWarnings("unused")
  private static final String TAG = AccountMediaModel.class.getSimpleName();

  /**
   * The unique identifier of the media item.
   */
  @JsonProperty("id")
  private String id;

  @JsonProperty("caption")
  private String caption;

  /**
   * Photo dimensions
   */
  @JsonProperty("dimensions")
  private String dimensions;

  /**
   * The URl that shows the location of the media item.
   */
  @JsonProperty("image_url")
  private String imageUrl;

  /**
   * The URL that shows the location of the thumbnail.
   */
  @JsonProperty("thumbnail")
  private String thumbnail;

  /**
   * Default non-args constructor.
   */
  public AccountMediaModel() {
    super();
  }

  /**
   * Getter and setter methods.
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getDimensions() {
    return dimensions;
  }

  public void setDimensions(String dimensions) {
    this.dimensions = dimensions;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public AccountMediaModel(Parcel in) {
    id = in.readString();
    caption = in.readString();
    dimensions = in.readString();
    imageUrl = in.readString();
    thumbnail = in.readString();
  }

  /*
   * (non-Javadoc)
   * @see android.os.Parcelable#describeContents()
   */
  @Override
  public int describeContents() {
    return 0;
  }

  /*
   * (non-Javadoc)
   * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
   */
  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(caption);
    dest.writeString(dimensions);
    dest.writeString(imageUrl);
    dest.writeString(thumbnail);
  }

  public static final Parcelable.Creator<AccountMediaModel> CREATOR = new Parcelable.Creator<AccountMediaModel>() {

    @Override
    public AccountMediaModel createFromParcel(Parcel in) {
      return new AccountMediaModel(in);
    }

    @Override
    public AccountMediaModel[] newArray(int size) {
      return new AccountMediaModel[size];
    }

  };

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountMediaModel [id=");
    builder.append(id);
    builder.append(", caption=");
    builder.append(caption);
    builder.append(", dimensions=");
    builder.append(dimensions);
    builder.append(", imageUrl=");
    builder.append(imageUrl);
    builder.append(", thumbnail=");
    builder.append(thumbnail);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public AccountMediaType getViewType() {
    return AccountMediaType.FILE;
  }

  @Override
  public String getName() {
    return getCaption();
  }

}
