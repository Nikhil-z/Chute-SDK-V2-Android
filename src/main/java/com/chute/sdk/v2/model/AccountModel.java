package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * The {@link AccountModel} class represents the concept of an account.
 * <p>
 * Each account contains type, name, shortcut, user details, access key, secret
 * and time of creation and update.
 * 
 */
public class AccountModel implements Parcelable {

  @SuppressWarnings("unused")
  private static final String TAG = AccountModel.class.getSimpleName();

  /**
   * The unique identifier of the account.
   */
  @JsonProperty("id")
  private String id;
  /**
   * Type of the account. It can be: facebook, picasa, flickr, instagram,
   * googledrive, skydrive, google or dropbox.
   */
  @JsonProperty("type")
  private String type;
  /**
   * Account name.
   */
  @JsonProperty("name")
  private String name;
  /**
   * Account user unique identifier.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * Time of creation.
   */
  @JsonProperty("created_at")
  private String createdAt;
  /**
   * Time of update.
   */
  @JsonProperty("updated_at")
  private String updatedAt;

  /**
   * Account shortcut.
   */
  @JsonProperty("shortcut")
  private String shortcut;

  /**
   * The username of the user currently authenticated.
   */
  @JsonProperty("username")
  private String username;

  /**
   * User avatar
   */
  @JsonProperty("avatar")
  private String avatar;

  /**
   * Account access key
   */
  @JsonProperty("access_key")
  private String accessKey;

  /**
   * Account access secret
   */
  @JsonProperty("access_secret")
  private String accessSecret;

  /**
   * E-mail of the user
   */
  @JsonProperty("email")
  private String email;

  /**
   * Default non-args constructor.
   */
  public AccountModel() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getAccessSecret() {
    return accessSecret;
  }

  public void setAccessSecret(String accessSecret) {
    this.accessSecret = accessSecret;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AccountModel(Parcel in) {
    id = in.readString();
    type = in.readString();
    name = in.readString();
    uid = in.readString();
    createdAt = in.readString();
    updatedAt = in.readString();
    shortcut = in.readString();
    username = in.readString();
    avatar = in.readString();
    accessKey = in.readString();
    accessSecret = in.readString();
    email = in.readString();
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
    dest.writeString(type);
    dest.writeString(name);
    dest.writeString(uid);
    dest.writeString(createdAt);
    dest.writeString(updatedAt);
    dest.writeString(shortcut);
    dest.writeString(username);
    dest.writeString(avatar);
    dest.writeString(accessKey);
    dest.writeString(accessSecret);
    dest.writeString(email);

  }

  public static final Parcelable.Creator<AccountModel> CREATOR = new Parcelable.Creator<AccountModel>() {

    @Override
    public AccountModel createFromParcel(Parcel in) {
      return new AccountModel(in);
    }

    @Override
    public AccountModel[] newArray(int size) {
      return new AccountModel[size];
    }
  };

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountModel [id=");
    builder.append(id);
    builder.append(", type=");
    builder.append(type);
    builder.append(", name=");
    builder.append(name);
    builder.append(", uid=");
    builder.append(uid);
    builder.append(", createdAt=");
    builder.append(createdAt);
    builder.append(", updatedAt=");
    builder.append(updatedAt);
    builder.append(", shortcut=");
    builder.append(shortcut);
    builder.append(", username=");
    builder.append(username);
    builder.append(", avatar=");
    builder.append(avatar);
    builder.append(", accessKey=");
    builder.append(accessKey);
    builder.append(", accessSecret=");
    builder.append(accessSecret);
    builder.append(", email=");
    builder.append(email);
    builder.append("]");
    return builder.toString();
  }

  /**
   * Serializes {@link AccountModel} as a String.
   * 
   * @return JSon string that contains all {@link AccountModel} fields and their
   *         appropriate values.
   */
  public String toJSON() {
    try {
      return JsonUtil.getMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
      ALog.e(e);
    }
    return "";
  }

  /**
   * Deserializes JSon content into {@link AccountModel}.
   * 
   * @param json
   *          The JSon that needs to be deserialized into {@link AccountModel}.
   * @return {@link AccountModel} containing values from the given JSon.
   */
  public static AccountModel fromJSON(String json) {
    try {
      return JsonUtil.getMapper().readValue(json, AccountModel.class);
    } catch (Exception e) {
      ALog.e(e);
    }
    return null;
  }

}
