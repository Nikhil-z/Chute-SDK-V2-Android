package com.chute.sdk.v2.api.asset;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class AlbumsGetAssetRequest extends
		ParameterHttpRequestImpl<ResponseModel<AssetModel>> {

	public static final String TAG = AlbumsGetAssetRequest.class
			.getSimpleName();
	final AlbumModel album;
	final AssetModel asset;

	public AlbumsGetAssetRequest(Context context, AlbumModel album,
			AssetModel asset, HttpCallback<ResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.GET, new ResponseParser<AssetModel>(
				AssetModel.class), callback);
		if (album == null || TextUtils.isEmpty(album.getId())) {
			throw new IllegalArgumentException("Need to provide album ID");
		}
		if (asset == null || TextUtils.isEmpty(asset.getId())) {
			throw new IllegalArgumentException("Need to provide asset ID");
		}
		this.album = album;
		this.asset = asset;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ALBUMS_GET_ASSET, album.getId(),
				asset.getId());
	}

}
