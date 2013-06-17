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
 * The {@link SourceModel} class holds asset source information such as source
 * URL, service, import URL and original URL.
 * 
 */
public class SourceModel implements Parcelable {

	public static final String TAG = SourceModel.class.getSimpleName();

	/**
	 * Asset source
	 */
	@JsonProperty("source")
	private String source;
	/**
	 * Source ID
	 */
	@JsonProperty("source_id")
	private String sourceId;
	/**
	 * Source URL
	 */
	@JsonProperty("source_url")
	private String sourceUrl;
	/**
	 * Source service
	 */
	@JsonProperty("service")
	private String service;
	/**
	 * Import ID
	 */
	@JsonProperty("import_id")
	private String importId;
	/**
	 * Import URL
	 */
	@JsonProperty("import_url")
	private String importUrl;
	/**
	 * Original URL
	 */
	@JsonProperty("original_url")
	private String originalUrl;

	public SourceModel() {
	}

	/**
	 * Getters and setters
	 */
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getImportId() {
		return importId;
	}

	public void setImportId(String importId) {
		this.importId = importId;
	}

	public String getImportUrl() {
		return importUrl;
	}

	public void setImportUrl(String importUrl) {
		this.importUrl = importUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public SourceModel(Parcel in) {
		source = in.readString();
		sourceId = in.readString();
		sourceUrl = in.readString();
		service = in.readString();
		importId = in.readString();
		importUrl = in.readString();
		originalUrl = in.readString();
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
		dest.writeString(source);
		dest.writeString(sourceId);
		dest.writeString(sourceUrl);
		dest.writeString(service);
		dest.writeString(importId);
		dest.writeString(importUrl);
		dest.writeString(originalUrl);
	}

	public static final Parcelable.Creator<SourceModel> CREATOR = new Parcelable.Creator<SourceModel>() {

		@Override
		public SourceModel createFromParcel(Parcel in) {
			return new SourceModel(in);
		}

		@Override
		public SourceModel[] newArray(int size) {
			return new SourceModel[size];
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SourceModel [source=" + source + ", sourceId=" + sourceId
				+ ", sourceUrl=" + sourceUrl + ", service=" + service
				+ ", importId=" + importId + ", importUrl=" + importUrl
				+ ", originalUrl=" + originalUrl + "]";
	}

}
