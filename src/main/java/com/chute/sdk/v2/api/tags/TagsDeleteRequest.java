package com.chute.sdk.v2.api.tags;

import java.util.ArrayList;

import org.json.JSONArray;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class TagsDeleteRequest extends
    ParameterHttpRequestImpl<ListResponseModel<String>> {

  public static final String TAG = TagsDeleteRequest.class.getSimpleName();
  private AssetModel asset;
  private AlbumModel album;
  private ArrayList<String> tags;

  public TagsDeleteRequest(Context context, AlbumModel album,
      AssetModel asset, ArrayList<String> tags,
      HttpCallback<ListResponseModel<String>> callback) {
    super(context, RequestMethod.DELETE, new ListResponseParser<String>(
        String.class), callback);
    this.tags = tags;
    if (asset == null || TextUtils.isEmpty(asset.getId())) {
      throw new IllegalArgumentException("Need to provide asset ID");
    }
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    if (tags.size() == 0) {
      throw new IllegalArgumentException(
          "Need to provide tags for updating the asset");
    }
    this.asset = asset;
    this.album = album;
  }

  @Override
  protected void doBeforeRunRequestInBackgroundThread() {
    super.doBeforeRunRequestInBackgroundThread();
    addParams(tags);
  }

  private void addParams(ArrayList<String> tags) {
    JSONArray array = new JSONArray();
    for (String tag : tags) {
      array.put(tag);
    }
    addParam("tags", array.toString());
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_ASSETS_TAGS, album.getId(),
        asset.getId());
  }

}
