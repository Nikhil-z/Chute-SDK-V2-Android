package com.chute.sdk.v2.api.comment;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class CommentsListRequest extends
    ParameterHttpRequestImpl<ListResponseModel<CommentModel>> {

  public static final String TAG = CommentsListRequest.class.getSimpleName();
  private final AlbumModel album;
  private final AssetModel asset;

  public CommentsListRequest(Context context, AlbumModel album,
      AssetModel asset,
      HttpCallback<ListResponseModel<CommentModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<CommentModel>(
        CommentModel.class), callback);
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    if (asset == null || TextUtils.isEmpty(asset.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    this.album = album;
    this.asset = asset;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_COMMENTS_GET, album.getId(),
        asset.getId());
  }

}
