package com.chute.sdk.v2.api.upload;

import java.util.ArrayList;
import java.util.List;

import com.chute.sdk.v2.model.AssetModel;

public class UploadTokenResponse {

	private List<AssetModel> assetCollection = new ArrayList<AssetModel>();

	private List<UploadToken> token = new ArrayList<UploadToken>();

	private String uploadId;

	public UploadTokenResponse() {
		super();
	}

	public List<AssetModel> getAssetCollection() {
		return assetCollection;
	}

	public void setAssetCollection(List<AssetModel> assetCollection) {
		this.assetCollection = assetCollection;
	}

	public List<UploadToken> getToken() {
		return token;
	}

	public void setToken(List<UploadToken> token) {
		this.token = token;
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
		builder.append("GCUploadTokenResponse [assetCollection=");
		builder.append(assetCollection);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}

}
