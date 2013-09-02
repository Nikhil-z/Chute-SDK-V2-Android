// Copyright (c) 2011, Chute Corporation. All rights reserved.
// 
//  Redistribution and use in source and binary forms, with or without modification, 
//  are permitted provided that the following conditions are met:
// 
//     * Redistributions of source code must retain the above copyright notice, this 
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
// 
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
// 
package com.chute.sdk.v2.api.album;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AlbumsImportRequest extends
    StringBodyHttpRequestImpl<ListResponseModel<AssetModel>> {

  public static final String TAG = AlbumsImportRequest.class.getSimpleName();
  private AlbumModel album;
  private ArrayList<String> urls;

  public AlbumsImportRequest(Context context, AlbumModel album, ArrayList<String> urls,
      HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.POST, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    if (album == null || TextUtils.isEmpty(album.getId())) {
      throw new IllegalArgumentException("Need to provide album ID");
    }
    this.album = album;
    if (urls == null || urls.size() == 0) {
      throw new IllegalArgumentException("Need to provide list of URLs for import");
    }
    this.urls = urls;
    addHeader("Content-Type", "application/json");
  }

  @Override
  public String bodyContents() {
    try {
      String bodyContent = JsonUtil.getMapper().writer().withRootName("urls")
          .writeValueAsString(urls);
      ALog.d("Body contents: " + bodyContent);
      return bodyContent;
    } catch (JsonProcessingException e) {
      Log.e(TAG, "", e);
    }
    return null;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_ALBUMS_IMPORT, album.getId());
  }

}
