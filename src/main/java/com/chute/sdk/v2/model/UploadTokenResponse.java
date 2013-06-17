package com.chute.sdk.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.chute.sdk.v2.model.requests.ListResponseModel;

public class UploadTokenResponse {

	private ListResponseModel<AssetModel> assetCollection = new ListResponseModel<AssetModel>();

	private List<UploadToken> token = new ArrayList<UploadToken>();

	private String uploadId;

	public UploadTokenResponse() {
		super();
	}

	public ListResponseModel<AssetModel> getAssetCollection() {
		return assetCollection;
	}

	public void setAssetCollection(ListResponseModel<AssetModel> assetCollection) {
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
		return "UploadTokenResponse [assetCollection=" + assetCollection
				+ ", token=" + token + ", uploadId=" + uploadId + "]";
	}

}
