package com.chute.sdk.v2.api.search;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class SearchLocationRequest extends
		ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

	public static final String TAG = SearchLocationRequest.class
			.getSimpleName();

	public SearchLocationRequest(Context context, AlbumModel album,
			GeoLocationModel geoLocation, int radius,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
				AssetModel.class), callback);
		if (geoLocation == null || TextUtils.isEmpty(geoLocation.getLatitude())
				|| TextUtils.isEmpty(geoLocation.getLongitude())) {
			throw new IllegalArgumentException(
					"Need to provide geo location information to execute search");
		}
		if (radius == 0) {
			throw new IllegalArgumentException(
					"Need to provide the radius in meters to execute search");
		}
		if (album != null || !TextUtils.isEmpty(album.getId())) {
			addParam("album_id", album.getId());
		}
		addParam("latitude", geoLocation.getLatitude());
		addParam("longitude", geoLocation.getLongitude());
		addParam("radius", String.valueOf(radius));
	}

	@Override
	protected String getUrl() {
		return RestConstants.URL_SEARCH_LOCATION;
	}

}
