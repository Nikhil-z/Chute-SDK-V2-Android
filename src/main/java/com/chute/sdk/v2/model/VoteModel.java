// Copyright (c) 2011, Chute Corporation. All rights reserved.
//
//  Redistribution and use in source and binary forms, with or without modification,
//  are permitted provided that the following conditions are met:
//
//     * Redistributions of source code must retain the above copyright notice, this
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
//
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
//
package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link VoteModel} class represents a concept of asset vote. Each vote
 * consists of: links, date of creation and update, identifier, asset ID and
 * album ID the vote belongs to.
 * 
 */
public class VoteModel implements Parcelable {

	public static final String TAG = VoteModel.class.getSimpleName();

	/**
	 * Unique identifier
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * Vote links
	 */
	@JsonProperty("links")
	private LinkModel links;
	/**
	 * Date and time of creation
	 */
	@JsonProperty("created_at")
	private String createdAt;
	/**
	 * Date and time of update
	 */
	@JsonProperty("updated_at")
	private String updatedAt;
	/**
	 * Vote identifier
	 */
	@JsonProperty("identifier")
	private String identifier;
	/**
	 * Album that holds the voted asset
	 */
	@JsonProperty("album_id")
	private String albumId;
	/**
	 * Asset the vote belongs to
	 */
	@JsonProperty("asset_id")
	private String assetId;
	/**
	 * Number of votes per asset
	 */
	@JsonProperty("count")
	private int count;

	/**
	 * Default non-args constructor
	 */
	public VoteModel() {
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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public VoteModel(Parcel in) {
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		createdAt = in.readString();
		updatedAt = in.readString();
		identifier = in.readString();
		albumId = in.readString();
		assetId = in.readString();
		count = in.readInt();
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
		dest.writeString(createdAt);
		dest.writeString(updatedAt);
		dest.writeString(identifier);
		dest.writeString(albumId);
		dest.writeString(assetId);
		dest.writeInt(count);

	}

	public static final Parcelable.Creator<VoteModel> CREATOR = new Parcelable.Creator<VoteModel>() {

		@Override
		public VoteModel createFromParcel(Parcel in) {
			return new VoteModel(in);
		}

		@Override
		public VoteModel[] newArray(int size) {
			return new VoteModel[size];
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlagModel [id=");
		builder.append(id);
		builder.append(", links=");
		builder.append(links);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", identifier=");
		builder.append(identifier);
		builder.append(", albumId=");
		builder.append(albumId);
		builder.append(", assetId=");
		builder.append(assetId);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}
}
