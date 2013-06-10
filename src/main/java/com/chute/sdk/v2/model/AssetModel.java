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

import java.util.ArrayList;

import com.chute.sdk.v2.utils.JsonUtil;
import com.dg.libs.android.logger.ALog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * An asset represents a single media item and all information connected to it,
 * viewed by everyone or privileged users. Each asset consists of links,
 * thumbnail, URL, type, caption, dimensions, source and the user which the
 * asset belongs to.
 * 
 */
public class AssetModel implements Parcelable {

	public static final String TAG = AssetModel.class.getSimpleName();

	/**
	 * Unique identifier
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * Asset links
	 */
	@JsonProperty("links")
	private LinkModel links;
	/**
	 * Thumbnail of the asset
	 */
	@JsonProperty("thumbnail")
	private String thumbnail;
	/**
	 * Asset URL
	 */
	@JsonProperty("url")
	private String url;
	/**
	 * Asset type. It can be image or video
	 */
	@JsonProperty("type")
	private String type;
	/**
	 * Asset caption information
	 */
	@JsonProperty("caption")
	private String caption;
	/**
	 * Width and height of the asset
	 */
	@JsonProperty("dimensions")
	private DimensionsModel dimensions;
	/**
	 * Asset source information
	 */
	@JsonProperty("source")
	private SourceModel source;
	/**
	 * The user the asset belongs to
	 */
	@JsonProperty("user")
	private UserModel user;

	@JsonProperty("votes")
	private int votes;
	@JsonProperty("hearts")
	private int hearts;
	@JsonProperty("tags")
	private ArrayList<String> tags;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("shortcut")
	private String shortcut;
	@JsonProperty("location")
	private String location;
	@JsonProperty("service")
	private String service;
	@JsonProperty("chute_asset_id")
	private String chuteAssetId;

	public AssetModel() {
	}

	/**
	 * Getters and setters
	 */

	public String getId() {
		return id;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getChuteAssetId() {
		return chuteAssetId;
	}

	public void setChuteAssetId(String chuteAssetId) {
		this.chuteAssetId = chuteAssetId;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public DimensionsModel getDimensions() {
		return dimensions;
	}

	public void setDimensions(DimensionsModel dimensions) {
		this.dimensions = dimensions;
	}

	public SourceModel getSource() {
		return source;
	}

	public void setSource(SourceModel source) {
		this.source = source;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@SuppressWarnings("unchecked")
	public AssetModel(Parcel in) {
		this();
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		thumbnail = in.readString();
		url = in.readString();
		type = in.readString();
		caption = in.readString();
		dimensions = in.readParcelable(DimensionsModel.class.getClassLoader());
		source = in.readParcelable(SourceModel.class.getClassLoader());
		user = in.readParcelable(UserModel.class.getClassLoader());
		votes = in.readInt();
		hearts = in.readInt();
		tags = in.readArrayList(String.class.getClassLoader());
		createdAt = in.readString();
		updatedAt = in.readString();
		shortcut = in.readString();
		location = in.readString();
		service = in.readString();
		chuteAssetId = in.readString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeParcelable(links, flags);
		dest.writeString(thumbnail);
		dest.writeString(url);
		dest.writeString(type);
		dest.writeString(caption);
		dest.writeParcelable(dimensions, flags);
		dest.writeParcelable(source, flags);
		dest.writeParcelable(user, flags);
		dest.writeInt(votes);
		dest.writeInt(hearts);
		dest.writeStringList(tags);
		dest.writeString(createdAt);
		dest.writeString(updatedAt);
		dest.writeString(shortcut);
		dest.writeString(location);
		dest.writeString(service);
		dest.writeString(chuteAssetId);
	}

	public static final Parcelable.Creator<AssetModel> CREATOR = new Parcelable.Creator<AssetModel>() {

		@Override
		public AssetModel createFromParcel(Parcel in) {
			return new AssetModel(in);
		}

		@Override
		public AssetModel[] newArray(int size) {
			return new AssetModel[size];
		}

	};

	public String serializeAsset() {
		String result = null;
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"assetModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("caption", "votes", "hearts"));
		try {
			result = JsonUtil.getMapper().writer(filter)
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			ALog.d("", e);
		}
		return result;
	}

	@Override
	public String toString() {
		return "AssetModel [id=" + id + ", links=" + links + ", thumbnail="
				+ thumbnail + ", url=" + url + ", type=" + type + ", caption="
				+ caption + ", dimensions=" + dimensions + ", source=" + source
				+ ", user=" + user + ", votes=" + votes + ", hearts=" + hearts
				+ ", tags=" + tags + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", shortcut=" + shortcut
				+ ", location=" + location + ", service=" + service
				+ ", chuteAssetId=" + chuteAssetId + "]";
	}

}
