package com.chute.sdk.v2.api.parcel;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class ParcelAlbumsRequest extends
    ParameterHttpRequestImpl<ListResponseModel<ParcelModel>> {

  public static final String TAG = ParcelAlbumsRequest.class.getSimpleName();
  private AlbumModel album;

  public ParcelAlbumsRequest(Context context, AlbumModel album,
      HttpCallback<ListResponseModel<ParcelModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<ParcelModel>(
        ParcelModel.class), callback);
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    this.album = album;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_PARCELS_ALBUMS, album.getId());
  }

}
