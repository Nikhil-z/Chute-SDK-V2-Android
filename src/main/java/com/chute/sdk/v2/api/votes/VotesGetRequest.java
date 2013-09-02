package com.chute.sdk.v2.api.votes;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class VotesGetRequest extends
    ParameterHttpRequestImpl<ResponseModel<VoteModel>> {

  public static final String TAG = VotesGetRequest.class.getSimpleName();
  private AlbumModel album;
  private AssetModel asset;

  public VotesGetRequest(Context context, AlbumModel album, AssetModel asset,
      HttpCallback<ResponseModel<VoteModel>> callback) {
    super(context, RequestMethod.GET, new ResponseParser<VoteModel>(
        VoteModel.class), callback);
    if (asset == null || TextUtils.isEmpty(asset.getId())) {
      throw new IllegalArgumentException("Need to provide asset ID");
    }
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    this.album = album;
    this.asset = asset;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_VOTES, album.getId(),
        asset.getId());
  }

}
