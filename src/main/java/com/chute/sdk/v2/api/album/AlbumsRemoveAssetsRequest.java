package com.chute.sdk.v2.api.album;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.parsers.NoResponseParser;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AlbumsRemoveAssetsRequest extends StringBodyHttpRequestImpl<Void> {

	public static final String TAG = AlbumsRemoveAssetsRequest.class
			.getSimpleName();
	private final AlbumModel album;
	private final ArrayList<String> assetIds;

	public AlbumsRemoveAssetsRequest(Context context, AlbumModel album,
			ArrayList<String> assetIds, HttpCallback<Void> callback) {
		super(context, RequestMethod.POST, new NoResponseParser(), callback);
		if (album == null || TextUtils.isEmpty(album.getId())) {
			throw new IllegalArgumentException("Need to provide album ID");
		}
		if (assetIds == null || assetIds.size() == 0) {
			throw new IllegalArgumentException(
					"Need to provide list of asset IDs for removal");
		}
		this.album = album;
		this.assetIds = assetIds;
	}

	@Override
	public String bodyContents() {
		try {
			return JsonUtil.getMapper().writer().withRootName("asset_ids")
					.writeValueAsString(assetIds);
		} catch (JsonProcessingException e) {
			Log.e(TAG, "", e);
		}
		return null;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ALBUMS_REMOVE_ASSETS,
				album.getId());
	}

}
