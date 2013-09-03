package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.chute.sdk.v2.model.enums.AccountMediaType;
import com.chute.sdk.v2.model.interfaces.AccountMedia;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link AccountAlbumModel} class represents the concept of an album from a
 * specific account. Each album contains ID and name.
 * 
 */
@JsonIgnoreProperties({ "links" })
public class AccountAlbumModel implements Parcelable, AccountMedia {

  @SuppressWarnings("unused")
  private static final String TAG = AccountAlbumModel.class.getSimpleName();

  /**
   * The unique identifier of the album.
   */
  @JsonProperty("id")
  private String id;
  /**
   * Name of the album.
   */
  @JsonProperty("name")
  private String name;

  @JsonProperty("links")
  private LinkInfoModel links;

  /**
   * Default non-args constructor.
   */
  public AccountAlbumModel() {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LinkInfoModel getLinks() {
    return links;
  }

  public void setLinks(LinkInfoModel links) {
    this.links = links;
  }

  public AccountAlbumModel(Parcel in) {
    id = in.readString();
    name = in.readString();
    links = in.readParcelable(LinkInfoModel.class.getClassLoader());
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
    dest.writeString(name);
    dest.writeParcelable(links, flags);
  }

  public static final Parcelable.Creator<AccountAlbumModel> CREATOR = new Parcelable.Creator<AccountAlbumModel>() {

    @Override
    public AccountAlbumModel createFromParcel(Parcel in) {
      return new AccountAlbumModel(in);
    }

    @Override
    public AccountAlbumModel[] newArray(int size) {
      return new AccountAlbumModel[size];
    }
  };

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountObjectModel [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append("]");
    return builder.toString();
  }

  /*
   * (non-Javadoc)
   * @see com.chute.sdk.v2.model.interfaces.AccountMedia#getViewType()
   */
  @Override
  public AccountMediaType getViewType() {
    return AccountMediaType.FOLDER;
  }

}
