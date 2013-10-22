// Copyright (c) 2011, Chute Corporation. All rights reserved.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution.
// * Neither the name of the Chute Corporation nor the names
// of its contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
// IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
// INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
// BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
// OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.
//
package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * Albums represent a collection of assets which can be created by a single
 * user, viewed by everyone or privileged users.
 * <p>
 * Each album contains links, counters, shortcut, name, which user it belongs
 * to, media and comments moderators and time and date of creation.
 */
@JsonFilter("albumModelFilter")
public class AlbumModel implements Parcelable {

  /**
   * Unique identifier.
   */
  @JsonProperty("id")
  private String id;

  /**
   * Album links.
   */
  @JsonProperty("links")
  private LinkModel links;

  /**
   * Album counters.
   */
  @JsonProperty("counters")
  private CounterModel counters;

  /**
   * Album Shortcut.
   */
  @JsonProperty("shortcut")
  private String shortcut;

  /**
   * Album name.
   */
  @JsonProperty("name")
  private String name;

  /**
   * The user the album belongs to.
   */
  @JsonProperty("user")
  private UserModel user;

  /**
   * Flag indicating whether media is moderated.
   */
  @JsonProperty("moderate_media")
  private boolean moderateMedia = false;

  /**
   * Flag indicating whether comments are moderated.
   */
  @JsonProperty("moderate_comments")
  private boolean moderateComments = false;

  /**
   * Time and date of creating the album.
   */
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * Time and date of updating the album.
   */
  @JsonProperty("updated_at")
  private String updatedAt;

  /**
   * Album description.
   */
  @JsonProperty("description")
  private String description;

  /**
   * Parent ID of the album.
   */
  @JsonProperty("parent_id")
  private String parentId;

  /**
   * Number of images in the album
   */
  @JsonProperty("images_count")
  private String imagesCount;

  /**
   * Album's first asset
   */
  @JsonProperty("asset")
  private AssetModel asset;

  /**
   * Cover asset
   */
  @JsonProperty("cover_asset")
  private AssetModel coverAsset;

  /**
   * Default non-args constructor
   */
  public AlbumModel() {
  }

  /**
   * Getters and setters
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LinkModel getLinks() {
    return links;
  }

  public void setLinks(LinkModel links) {
    this.links = links;
  }

  public CounterModel getCounters() {
    return counters;
  }

  public void setCounters(CounterModel counters) {
    this.counters = counters;
  }

  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserModel getUser() {
    return user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public boolean isModerateMedia() {
    return moderateMedia;
  }

  public void setModerateMedia(boolean moderateMedia) {
    this.moderateMedia = moderateMedia;
  }

  public boolean isModerateComments() {
    return moderateComments;
  }

  public void setModerateComments(boolean moderateComments) {
    this.moderateComments = moderateComments;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(String imagesCount) {
    this.imagesCount = imagesCount;
  }

  public AssetModel getAsset() {
    return asset;
  }

  public void setAsset(AssetModel asset) {
    this.asset = asset;
  }

  public AssetModel getCoverAsset() {
    return coverAsset;
  }

  public void setCoverAsset(AssetModel coverAsset) {
    this.coverAsset = coverAsset;
  }

  /**
   * Method used for serializing Album object as a String.
   */
  public String serializeAlbum() {
    FilterProvider filters = new SimpleFilterProvider().addFilter("albumModelFilter",
        SimpleBeanPropertyFilter.filterOutAllExcept("name", "moderate_comments",
            "moderate_media"));
    String result = null;
    try {
      result = JsonUtil.getMapper().writer(filters).writeValueAsString(this);
    } catch (JsonProcessingException e) {
      ALog.d("", e);
    }
    return result;
  }

  public AlbumModel(Parcel in) {
    this();
    id = in.readString();
    links = in.readParcelable(LinkModel.class.getClassLoader());
    counters = in.readParcelable(CounterModel.class.getClassLoader());
    shortcut = in.readString();
    name = in.readString();
    user = in.readParcelable(UserModel.class.getClassLoader());
    moderateMedia = in.readInt() == 1;
    moderateComments = in.readInt() == 1;
    createdAt = in.readString();
    updatedAt = in.readString();
    description = in.readString();
    parentId = in.readString();
    imagesCount = in.readString();
    asset = in.readParcelable(AssetModel.class.getClassLoader());
    coverAsset = in.readParcelable(AssetModel.class.getClassLoader());
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
    dest.writeParcelable(links, flags);
    dest.writeParcelable(counters, flags);
    dest.writeString(shortcut);
    dest.writeString(name);
    dest.writeParcelable(user, flags);
    dest.writeInt(moderateMedia ? 1 : 0);
    dest.writeInt(moderateComments ? 1 : 0);
    dest.writeString(createdAt);
    dest.writeString(updatedAt);
    dest.writeString(description);
    dest.writeString(parentId);
    dest.writeString(imagesCount);
    dest.writeParcelable(asset, flags);
    dest.writeParcelable(coverAsset, flags);
  }

  public static final Parcelable.Creator<AlbumModel> CREATOR = new Parcelable.Creator<AlbumModel>() {

    @Override
    public AlbumModel createFromParcel(Parcel in) {
      return new AlbumModel(in);
    }

    @Override
    public AlbumModel[] newArray(int size) {
      return new AlbumModel[size];
    }

  };

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AlbumModel [id=");
    builder.append(id);
    builder.append(", links=");
    builder.append(links);
    builder.append(", counters=");
    builder.append(counters);
    builder.append(", shortcut=");
    builder.append(shortcut);
    builder.append(", name=");
    builder.append(name);
    builder.append(", user=");
    builder.append(user);
    builder.append(", moderateMedia=");
    builder.append(moderateMedia);
    builder.append(", moderateComments=");
    builder.append(moderateComments);
    builder.append(", createdAt=");
    builder.append(createdAt);
    builder.append(", updatedAt=");
    builder.append(updatedAt);
    builder.append(", description=");
    builder.append(description);
    builder.append(", parentId=");
    builder.append(parentId);
    builder.append(", imagesCount=");
    builder.append(imagesCount);
    builder.append(", asset=");
    builder.append(asset);
    builder.append(", coverAsset=");
    builder.append(coverAsset);
    builder.append("]");
    return builder.toString();
  }

}