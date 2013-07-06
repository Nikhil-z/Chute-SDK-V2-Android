package com.chute.sdk.v2.api.asset;

import java.io.File;

import android.content.Context;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.FileBodyHttpRequestImpl;

public class AssetsFileRequest extends FileBodyHttpRequestImpl<ListResponseModel<AssetModel>> {

	private String filePath;
	private AlbumModel album;
	private String token;

	public AssetsFileRequest(Context context, AlbumModel album, String filePath, String token,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.POST, new ListResponseParser<AssetModel>(AssetModel.class), callback);
		this.filePath = filePath;
		this.album = album;
		this.token = token;
		if (token == null) {
			throw new NullPointerException("Token cannot be null");
		}
		if (album == null) {
			throw new NullPointerException("Album cannot be null");
		}
//		addHeader("Content-Type", "image/jpg");
	}

	@Override
	public File fileToSend() {
		File file = new File(filePath);
		return file;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_UPLOAD_ONE_STEP, album.getId());
	}


}
