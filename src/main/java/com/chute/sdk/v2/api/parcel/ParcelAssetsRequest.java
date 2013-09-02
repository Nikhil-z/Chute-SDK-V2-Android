package com.chute.sdk.v2.api.parcel;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class ParcelAssetsRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = ParcelAssetsRequest.class.getSimpleName();
  private ParcelModel parcel;

  public ParcelAssetsRequest(Context context, ParcelModel parcel,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    if (parcel == null || TextUtils.isEmpty(parcel.getId())) {
      throw new IllegalArgumentException("Need to provide parcel ID");
    }
    this.parcel = parcel;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_PARCELS_ASSETS, parcel.getId());
  }

}
