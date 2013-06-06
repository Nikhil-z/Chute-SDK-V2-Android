package com.chute.sdk.v2.api.tags;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TagsAddRequest extends
		StringBodyHttpRequestImpl<ListResponseModel<String>> {

	public static final String TAG = TagsAddRequest.class.getSimpleName();
	private AssetModel asset;
	private AlbumModel album;
	private ArrayList<String> tags;

	public TagsAddRequest(Context context, AlbumModel album, AssetModel asset,
			ArrayList<String> tags,
			HttpCallback<ListResponseModel<String>> callback) {
		super(context, RequestMethod.POST, new ListResponseParser<String>(
				String.class), callback);
		if (asset == null || TextUtils.isEmpty(asset.getId())) {
			throw new IllegalArgumentException("Need to provide asset ID");
		}
		if (album == null || TextUtils.isEmpty(album.getId())) {
			throw new IllegalArgumentException("Need to provide album ID");
		}
		if (tags.size() == 0) {
			throw new IllegalArgumentException(
					"Need to provide tags for updating the asset");
		}
		this.asset = asset;
		this.album = album;
		this.tags = tags;
	}

	@Override
	public String bodyContents() {
		try {
			return JsonUtil.getMapper().writer().withRootName("tags")
					.writeValueAsString(tags);
		} catch (JsonProcessingException e) {
			Log.e(TAG, "", e);
		}
		return null;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ASSETS_TAGS, album.getId(),
				asset.getId());
	}

}
