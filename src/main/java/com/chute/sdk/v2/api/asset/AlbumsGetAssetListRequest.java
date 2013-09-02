package com.chute.sdk.v2.api.asset;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.PaginationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class AlbumsGetAssetListRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = AlbumsGetAssetListRequest.class
      .getSimpleName();
  final AlbumModel album;

  public AlbumsGetAssetListRequest(Context context, AlbumModel album,
      PaginationModel pagination,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    this.album = album;
    addParam("per_page", pagination.getPerPageAsString());
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_ALBUMS_GET_ALL_ASSETS,
        album.getId());
  }

}
