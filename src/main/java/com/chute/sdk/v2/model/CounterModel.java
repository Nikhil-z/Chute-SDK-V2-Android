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
 * The {@link CounterModel} class wraps information regarding number of photo,
 * video and inbox items for an asset or album.
 * 
 */
public class CounterModel implements Parcelable {

	/**
	 * Number of photos
	 */
	@JsonProperty("photos")
	private long photos;
	/**
	 * Number of videos
	 */
	@JsonProperty("videos")
	private long videos;
	/**
	 * Number of inbox items
	 */
	@JsonProperty("inbox")
	private long inbox;

	public CounterModel() {
	}

	/**
	 * Getters and setters
	 */
	public long getPhotos() {
		return photos;
	}

	public void setPhotos(long photos) {
		this.photos = photos;
	}

	public long getVideos() {
		return videos;
	}

	public void setVideos(long videos) {
		this.videos = videos;
	}

	public long getInbox() {
		return inbox;
	}

	public void setInbox(long inbox) {
		this.inbox = inbox;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CounterModel [photos=");
		builder.append(photos);
		builder.append(", videos=");
		builder.append(videos);
		builder.append(", inbox=");
		builder.append(inbox);
		builder.append("]");
		return builder.toString();
	}

	public CounterModel(Parcel in) {
		this();
		photos = in.readLong();
		videos = in.readLong();
		inbox = in.readLong();
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
		dest.writeLong(photos);
		dest.writeLong(videos);
		dest.writeLong(inbox);
	}

	public static final Parcelable.Creator<CounterModel> CREATOR = new Parcelable.Creator<CounterModel>() {

		@Override
		public CounterModel createFromParcel(Parcel in) {
			return new CounterModel(in);
		}

		@Override
		public CounterModel[] newArray(int size) {
			return new CounterModel[size];
		}

	};

}