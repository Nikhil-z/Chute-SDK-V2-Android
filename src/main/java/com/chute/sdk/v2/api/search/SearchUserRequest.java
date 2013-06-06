package com.chute.sdk.v2.api.search;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.UserModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class SearchUserRequest extends
		ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

	public static final String TAG = SearchUserRequest.class.getSimpleName();

	public SearchUserRequest(Context context, AlbumModel album, UserModel user,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
				AssetModel.class), callback);
		if (user == null || TextUtils.isEmpty(user.getUsername())) {
			throw new IllegalArgumentException(
					"Need to provide username in order to perform the search");
		}
		if (album != null || !TextUtils.isEmpty(album.getId())) {
			addParam("album_id", album.getId());
		}
		addParam("query[username]", user.getUsername());
	}

	@Override
	protected String getUrl() {
		return RestConstants.URL_SEARCH_USER;
	}

}
