package com.chute.sdk.v2.api.geo;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class GeoLocationGetAssetsRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = GeoLocationGetRequest.class
      .getSimpleName();
  public AssetModel asset;
  public String latitude;
  public String longitude;
  public String radius;

  public GeoLocationGetAssetsRequest(Context context, AssetModel asset,
      String latitude, String longitude, String radius,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
        GeoLocationModel.class), callback);
    if (asset == null || TextUtils.isEmpty(asset.getId())) {
      throw new IllegalArgumentException("Need to provide asset ID");
    }
    if (latitude == null) {
      throw new IllegalArgumentException("Need to provide asset latitude");
    }
    if (longitude == null) {
      throw new IllegalArgumentException(
          "Need to provide asset longitude");
    }
    if (radius == null) {
      throw new IllegalArgumentException("Need to provide asset radius");
    }
    this.asset = asset;
    this.latitude = latitude;
    this.longitude = longitude;
    this.radius = radius;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_ASSETS_GET_GEO_LOCATION,
        latitude, longitude, radius);
  }

}
