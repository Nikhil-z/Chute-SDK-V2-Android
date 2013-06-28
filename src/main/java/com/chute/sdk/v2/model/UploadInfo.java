package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link UploadInfo} class contains upload information: signature, date of
 * upload, uploaded photo URL, the path and type of the uploaded file.
 * 
 */
public class UploadInfo {

	/**
	 * Uploaded file signature
	 */
	@JsonProperty("signature")
	private String signature;

	/**
	 * Time and date when the photo has been uploaded
	 */
	@JsonProperty("date")
	private String date;

	/**
	 * Uploaded photo URL
	 */
	@JsonProperty("upload_url")
	private String uploadUrl;

	/**
	 * Path pointing to the photo on the device
	 */
	@JsonProperty("file_path")
	private String filepath;

	/**
	 * File type: image or video
	 */
	@JsonProperty("content_type")
	private String contentType;

	/**
	 * Cloud service type
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Getters and setters
	 */
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
		StringBuilder builder = new StringBuilder();
		builder.append("UploadInfo [signature=");
		builder.append(signature);
		builder.append(", date=");
		builder.append(date);
		builder.append(", uploadUrl=");
		builder.append(uploadUrl);
		builder.append(", filepath=");
		builder.append(filepath);
		builder.append(", contentType=");
		builder.append(contentType);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
