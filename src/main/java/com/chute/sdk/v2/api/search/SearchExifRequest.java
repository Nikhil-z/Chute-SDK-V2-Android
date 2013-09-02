package com.chute.sdk.v2.api.search;

import java.util.HashMap;
import java.util.Iterator;

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

public class SearchExifRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = SearchExifRequest.class.getSimpleName();
  private AlbumModel album;
  private HashMap<String, String> exif;

  public SearchExifRequest(Context context, AlbumModel album,
      HashMap<String, String> exif,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.GET, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    this.album = album;
    this.exif = exif;
    if (exif == null || exif.isEmpty()) {
      throw new IllegalArgumentException(
          "Need to provide exif information to execute search");
    }

  }

  @Override
  protected void doBeforeRunRequestInBackgroundThread() {
    super.doBeforeRunRequestInBackgroundThread();
    addParams(album, exif);

  }

  private void addParams(AlbumModel album, HashMap<String, String> exif) {
    if (album != null || !TextUtils.isEmpty(album.getId())) {
      addParam("album_id", album.getId());
    }
    JSONArray exifArray = new JSONArray();
    Iterator iterator = exif.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      exifArray.put(exif.get(key));
    }
    addParam("query[key]", exifArray.toString());
  }

  @Override
  protected String getUrl() {
    return RestConstants.URL_SEARCH_EXIF;
  }
}
