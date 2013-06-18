package com.chute.sdk.v2.api.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadInfo {

	@JsonProperty("signature")
	private String signature;

	@JsonProperty("date")
	private String date;

	@JsonProperty("upload_url")
	private String uploadUrl;

	@JsonProperty("file_path")
	private String filepath;
	@JsonProperty("content_type")
	private String contentType;

	@JsonProperty("type")
	private String type;

	public UploadInfo() {
		super();
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UploadInfo [signature=" + signature + ", date=" + date
				+ ", uploadUrl=" + uploadUrl + ", filepath=" + filepath
				+ ", contentType=" + contentType + ", type=" + type + "]";
	}

}
