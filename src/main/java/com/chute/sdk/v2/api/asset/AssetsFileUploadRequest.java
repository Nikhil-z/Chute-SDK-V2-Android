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
package com.chute.sdk.v2.api.asset;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import android.content.Context;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.api.upload.CountingMultipartRequestEntity;
import com.chute.sdk.v2.api.upload.CountingMultipartRequestEntity.ProgressListener;
import com.chute.sdk.v2.api.upload.UploadProgressListener;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.HttpRequestStore;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.domain.RequestOptions;
import com.dg.libs.rest.requests.EntityHttpRequestImpl;

public class AssetsFileUploadRequest extends
    EntityHttpRequestImpl<ListResponseModel<AssetModel>> implements
    ProgressListener {

  private AlbumModel album;
  private UploadProgressListener uploadListener;
  private File file;
  private CountingMultipartRequestEntity countingMultipartRequestEntity;

  public AssetsFileUploadRequest(Context context, UploadProgressListener uploadListener,
      AlbumModel album,
      String filePath, String clientId, HttpCallback<ListResponseModel<AssetModel>> callback) {
    super(context, RequestMethod.POST, new ListResponseParser<AssetModel>(
        AssetModel.class), callback);
    this.album = album;
    this.uploadListener = uploadListener;
    this.file = new File(filePath);
    if (album == null) {
      throw new NullPointerException("Album cannot be null");
    }
    if (filePath == null) {
      throw new NullPointerException("File path cannot be null");
    }
    if (clientId != null) {
    	addParam("client_id", clientId);
    }
    
    MultipartEntity multipartEntity = null;
    try {
      multipartEntity = new MultipartEntity();
      multipartEntity.addPart("filedata", new FileBody(file));
      countingMultipartRequestEntity = new CountingMultipartRequestEntity(multipartEntity, this);
    } catch (Exception e) {
      ALog.d("Multipart Entitiy Exception = " + e.getMessage(), e);
      throw new IllegalArgumentException("Unable to create entity");
    }
    
  }
  
  public void cancel(){
    countingMultipartRequestEntity.cancel();
  }

  @Override
  public HttpEntity getEntity() {
    return countingMultipartRequestEntity;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_UPLOAD_ONE_STEP, album.getId());

  }

  @Override
  public void transferred(long num) {
    uploadListener.onProgress(file.length(), num);
  }

  @Override
  protected void doBeforeRunRequestInBackgroundThread() {
    super.doBeforeRunRequestInBackgroundThread();
    if (uploadListener != null) {
      uploadListener.onUploadStarted(file);
    }
  }

  @Override
  protected void doAfterRunRequestInBackgroundThread() {
    super.doAfterRunRequestInBackgroundThread();
    if (uploadListener != null) {
      uploadListener.onUploadFinished(file);
    }
  }

  @Override
  public void executeAsync() {
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.setRunInSingleThread(true);
    HttpRequestStore.getInstance(getContext()).launchServiceIntent(this, requestOptions);
  }
}
