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
 * The {@link DimensionsModel} class contains information regarding dimensions
 * of an asset.
 * 
 */
@JsonPropertyOrder({ "width", "height" })
public class DimensionsModel implements Parcelable {

	public static final String TAG = DimensionsModel.class.getSimpleName();

	/**
	 * Width of the asset
	 */
	@JsonProperty("width")
	private long width;
	/**
	 * Asset height
	 */
	@JsonProperty("height")
	private long height;

	public DimensionsModel() {
	}

	/**
	 * Getters and setters
	 */
	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public DimensionsModel withWidth(long width) {
		this.width = width;
		return this;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public DimensionsModel withHeight(long height) {
		this.height = height;
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
		builder.append("DimensionsModel [width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

	public DimensionsModel(Parcel in) {
		this();
		width = in.readLong();
		height = in.readLong();
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
		dest.writeLong(width);
		dest.writeLong(height);
	}

	public static final Parcelable.Creator<DimensionsModel> CREATOR = new Parcelable.Creator<DimensionsModel>() {

		@Override
		public DimensionsModel createFromParcel(Parcel in) {
			return new DimensionsModel(in);
		}

		@Override
		public DimensionsModel[] newArray(int size) {
			return new DimensionsModel[size];
		}

	};

}
