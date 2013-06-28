package com.chute.sdk.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing the upload token response. Contains list of new and
 * existing assets and upload ID.
 * 
 */
public class UploadTokenResponse {

	/**
	 * List of new assets
	 */
	@JsonProperty("new_assets")
	private List<UploadToken> newAssets = new ArrayList<UploadToken>();

	/**
	 * List of existing assets
	 */
	@JsonProperty("existing_assets")
	private List<UploadToken> existingAssets = new ArrayList<UploadToken>();

	/**
	 * Upload ID
	 */
	@JsonProperty("id")
	private String uploadId;

	/**
	 * Getters and setters
	 */
	public List<UploadToken> getNewAssets() {
		return newAssets;
	}

	public void setNewAssets(List<UploadToken> newAssets) {
		this.newAssets = newAssets;
	}

	public List<UploadToken> getExistingAssets() {
		return existingAssets;
	}

	public void setExistingAssets(List<UploadToken> existingAssets) {
		this.existingAssets = existingAssets;
	}

	public String getUploadId() {
		return uploadId;
	}

	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadTokenResponse [newAssets=");
		builder.append(newAssets);
		builder.append(", existingAssets=");
		builder.append(existingAssets);
		builder.append(", uploadId=");
		builder.append(uploadId);
		builder.append("]");
		return builder.toString();
	}

}
