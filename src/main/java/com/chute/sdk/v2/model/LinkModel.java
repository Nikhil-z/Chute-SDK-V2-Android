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


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The {@link LinkModel} class holds self, asset and exif links.
 * 
 */
@JsonPropertyOrder({ "self", "assets", "exif" })
public class LinkModel implements Parcelable {

	/**
	 * Self data links
	 */
	@JsonProperty("self")
	private LinkInfoModel self;
	/**
	 * Asset links
	 */
	@JsonProperty("assets")
	private LinkInfoModel assets;
	/**
	 * Exif data links
	 */
	@JsonProperty("exif")
	private LinkInfoModel exif;

	public LinkModel() {
	}

	/**
	 * Getters and setters
	 */
	public LinkInfoModel getSelf() {
		return self;
	}

	public void setSelf(LinkInfoModel self) {
		this.self = self;
	}

	public LinkModel withSelf(LinkInfoModel self) {
		this.self = self;
		return this;
	}

	public LinkInfoModel getAssets() {
		return assets;
	}

	public void setAssets(LinkInfoModel assets) {
		this.assets = assets;
	}

	public LinkModel withAssets(LinkInfoModel assets) {
		this.assets = assets;
		return this;
	}

	public LinkInfoModel getExif() {
		return exif;
	}

	public void setExif(LinkInfoModel exif) {
		this.exif = exif;
	}

	public LinkModel withExif(LinkInfoModel exif) {
		this.exif = exif;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkModel [self=");
		builder.append(self);
		builder.append(", assets=");
		builder.append(assets);
		builder.append(", exif=");
		builder.append(exif);
		builder.append("]");
		return builder.toString();
	}

	public LinkModel(Parcel in) {
		self = in.readParcelable(LinkInfoModel.class.getClassLoader());
		assets = in.readParcelable(LinkInfoModel.class.getClassLoader());
		exif = in.readParcelable(LinkInfoModel.class.getClassLoader());
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
		dest.writeParcelable(self, flags);
		dest.writeParcelable(assets, flags);
		dest.writeParcelable(exif, flags);
	}

	public static final Parcelable.Creator<LinkModel> CREATOR = new Parcelable.Creator<LinkModel>() {

		@Override
		public LinkModel createFromParcel(Parcel in) {
			return new LinkModel(in);
		}

		@Override
		public LinkModel[] newArray(int size) {
			return new LinkModel[size];
		}

	};

}