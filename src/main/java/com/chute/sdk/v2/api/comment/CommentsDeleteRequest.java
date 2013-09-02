package com.chute.sdk.v2.api.comment;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class CommentsDeleteRequest extends
    ParameterHttpRequestImpl<ResponseModel<CommentModel>> {

  public static final String TAG = CommentsDeleteRequest.class
      .getSimpleName();
  private final CommentModel comment;

  public CommentsDeleteRequest(Context context, CommentModel comment,
      HttpCallback<ResponseModel<CommentModel>> callback) {
    super(context, RequestMethod.DELETE, new ResponseParser<CommentModel>(
        CommentModel.class), callback);
    if (comment == null || TextUtils.isEmpty(comment.getId())) {
      throw new IllegalArgumentException("Need to provide comment ID");
    }
    this.comment = comment;
  }

  @Override
  protected String getUrl() {
    return String
        .format(RestConstants.URL_COMMENTS_DELETE, comment.getId());
  }

}
