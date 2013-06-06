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


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcels represent a group of assets. A parcel contains all assets that were
 * uploaded or imported in a single run. A simple example is calling the import
 * function with multiple image URLs. All these images will be grouped in a
 * single parcel.Each parcel consists of links, date and time of creation and
 * update and shortcut.
 * 
 */
@JsonPropertyOrder({ "id", "links", "created_at", "updated_at", "shortcut" })
public class ParcelModel implements Parcelable {

	public static final String TAG = ParcelModel.class.getSimpleName();

	/**
	 * Unique identifier
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * Parcel links
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
	 * Parcel shortcut
	 */
	@JsonProperty("shortcut")
	private String shortcut;

	/**
	 * Default non-args constructor
	 */
	public ParcelModel() {
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

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParcelModel [id=");
		builder.append(id);
		builder.append(", links=");
		builder.append(links);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", shortcut=");
		builder.append(shortcut);
		builder.append("]");
		return builder.toString();
	}

	public ParcelModel(Parcel in) {
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		createdAt = in.readString();
		updatedAt = in.readString();
		shortcut = in.readString();
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
		dest.writeString(shortcut);
	}

	public static final Parcelable.Creator<ParcelModel> CREATOR = new Parcelable.Creator<ParcelModel>() {

		@Override
		public ParcelModel createFromParcel(Parcel in) {
			return new ParcelModel(in);
		}

		@Override
		public ParcelModel[] newArray(int size) {
			return new ParcelModel[size];
		}

	};

}
