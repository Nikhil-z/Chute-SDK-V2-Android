package com.chute.sdk.v2.api.comment;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;

public class CommentsCreateRequest extends
		StringBodyHttpRequestImpl<ResponseModel<CommentModel>> {

	public static final String TAG = CommentsCreateRequest.class
			.getSimpleName();
	private final AlbumModel album;
	private final AssetModel asset;
	private final CommentModel comment;

	public CommentsCreateRequest(Context context, AlbumModel album,
			AssetModel asset, CommentModel comment,
			HttpCallback<ResponseModel<CommentModel>> callback) {
		super(context, RequestMethod.POST, new ResponseParser<CommentModel>(
				CommentModel.class), callback);
		if (album == null || TextUtils.isEmpty(album.getId())) {
			throw new IllegalArgumentException("Need to provide album ID");
		}
		if (asset == null || TextUtils.isEmpty(asset.getId())) {
			throw new IllegalArgumentException("Need to provide asset ID");
		}
		if (comment == null || TextUtils.isEmpty(comment.getCommentText())) {
			throw new IllegalArgumentException("Need to provide comment text");
		}
		this.album = album;
		this.asset = asset;
		this.comment = comment;
	}

	@Override
	public String bodyContents() {
		return this.comment.serializeComment();
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_COMMENTS_CREATE, album.getId(),
				asset.getId());
	}

}
