package com.chute.sdk.v2.api.search;

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

public class SearchTagsRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = SearchTagsRequest.class.getSimpleName();
  private AlbumModel album;
  private ArrayList<String> tags;

  public SearchTagsRequest(Context context, AlbumModel album,
      ArrayList<String> tags,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    this.album = album;
    this.tags = tags;
    if (tags == null || tags.isEmpty()) {
      throw new IllegalArgumentException(
          "Need to provide an array of tags to execute search");
    }
  }

  @Override
  protected void doBeforeRunRequestInBackgroundThread() {
    super.doBeforeRunRequestInBackgroundThread();
    addParams(album, tags);
  }

  private void addParams(AlbumModel album, ArrayList<String> tags) {
    if (album != null || !TextUtils.isEmpty(album.getId())) {
      addParam("album_id", album.getId());
    }
    JSONArray tagArray = new JSONArray();
    for (String tag : tags) {
      tagArray.put(tag);
    }
    addParam("query[tags]", tagArray.toString());
  }

  @Override
  protected String getUrl() {
    return RestConstants.URL_SEARCH_TAGS;
  }

}
