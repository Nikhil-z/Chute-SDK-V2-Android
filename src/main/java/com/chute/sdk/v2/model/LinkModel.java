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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The {@link LinkModel} class holds self, asset and exif links.
 * 
 */
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
	/**
	 * Geo location links
	 */
	@JsonProperty("geo")
	private LinkInfoModel geo;
	/**
	 * Hearting info links
	 */
	@JsonProperty("heart")
	private LinkInfoModel heart;
	/**
	 * Vote info links
	 */
	@JsonProperty("vote")
	private LinkInfoModel vote;
	/**
	 * Parcel links
	 */
	@JsonProperty("parcels")
	private LinkInfoModel parcels;

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

	public LinkInfoModel getAssets() {
		return assets;
	}

	public void setAssets(LinkInfoModel assets) {
		this.assets = assets;
	}

	public LinkInfoModel getExif() {
		return exif;
	}

	public void setExif(LinkInfoModel exif) {
		this.exif = exif;
	}

	public LinkInfoModel getGeo() {
		return geo;
	}

	public void setGeo(LinkInfoModel geo) {
		this.geo = geo;
	}

	public LinkInfoModel getHeart() {
		return heart;
	}

	public void setHeart(LinkInfoModel heart) {
		this.heart = heart;
	}

	public LinkInfoModel getVote() {
		return vote;
	}

	public void setVote(LinkInfoModel vote) {
		this.vote = vote;
	}

	public LinkInfoModel getParcels() {
		return parcels;
	}

	public void setParcels(LinkInfoModel parcels) {
		this.parcels = parcels;
	}

	public LinkModel(Parcel in) {
		self = in.readParcelable(LinkInfoModel.class.getClassLoader());
		assets = in.readParcelable(LinkInfoModel.class.getClassLoader());
		exif = in.readParcelable(LinkInfoModel.class.getClassLoader());
		geo = in.readParcelable(LinkInfoModel.class.getClassLoader());
		heart = in.readParcelable(LinkInfoModel.class.getClassLoader());
		vote = in.readParcelable(LinkInfoModel.class.getClassLoader());
		parcels = in.readParcelable(LinkInfoModel.class.getClassLoader());
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
		dest.writeParcelable(self, flags);
		dest.writeParcelable(assets, flags);
		dest.writeParcelable(exif, flags);
		dest.writeParcelable(geo, flags);
		dest.writeParcelable(heart, flags);
		dest.writeParcelable(vote, flags);
		dest.writeParcelable(parcels, flags);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LinkModel [self=" + self + ", assets=" + assets + ", exif="
				+ exif + ", geo=" + geo + ", heart=" + heart + ", vote=" + vote
				+ ", parcels=" + parcels + "]";
	}

}