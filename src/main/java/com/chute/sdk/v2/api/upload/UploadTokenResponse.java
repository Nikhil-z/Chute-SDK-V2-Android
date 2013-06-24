package com.chute.sdk.v2.api.upload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadTokenResponse {

	@JsonProperty("new_assets")
	private List<UploadToken> newAssets = new ArrayList<UploadToken>();

	@JsonProperty("existing_assets")
	private List<UploadToken> existingAssets = new ArrayList<UploadToken>();

	@JsonProperty("id")
	private String uploadId;

	@JsonProperty("meta")
	private Meta meta;

	public UploadTokenResponse() {
		super();
	}

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

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "UploadTokenResponse [newAssets=" + newAssets
				+ ", existingAssets=" + existingAssets + ", uploadId="
				+ uploadId + ", meta=" + meta + "]";
	}

}
