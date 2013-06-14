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

import java.util.ArrayList;
import java.util.List;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.UploadToken;
import com.chute.sdk.v2.model.UploadTokenResponse;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.chute.sdk.v2.utils.rest.GCS3Uploader;
import com.dg.libs.android.logger.ALog;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.HttpRequestStore;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

import darko.imagedownloader.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class AssetsUploadRequest implements HttpRequest {

	public static final String TAG = AssetsUploadRequest.class.getSimpleName();
	private final List<AssetModel> localAssetCollection;
	private final UploadProgressListener onProgressUpdate;
	private final HttpCallback<ListResponseModel<AssetModel>> callback;
	private static final Handler handler = new Handler(Looper.getMainLooper());

	private UploadTokenResponse list;

	private final Context context;
	final ArrayList<String> chuteIds = new ArrayList<String>();

	public void resumeThread() {
		synchronized (this) {
			Log.w(TAG, "Resumed thread");
			this.notifyAll();
		}
	}

	public AssetsUploadRequest(final Context context,
			final UploadProgressListener onProgressUpdate,
			final HttpCallback<ListResponseModel<AssetModel>> callback,
			final List<AssetModel> assetCollection,
			final List<AlbumModel> chuteCollection) {
		this.context = context;
		this.callback = callback;

		if (assetCollection == null || assetCollection.size() == 0) {
			throw new NullPointerException(
					"Need to provide an array with at least 1 item (Not NULL)");
		}
		for (final AlbumModel chuteModel : chuteCollection) {
			chuteIds.add(chuteModel.getId());
		}
		this.onProgressUpdate = onProgressUpdate;
		this.localAssetCollection = assetCollection;
	}

	@Override
	public void execute() {
		final GCS3Uploader uploader = new GCS3Uploader(onProgressUpdate);
		try {
			final HttpRequest token = getToken(context, localAssetCollection,
					chuteIds, new TokenListener());
			synchronized (this) {
				ALog.w(TAG, "Wait thread");
				token.execute();
				this.wait(4000);
			}
			for (int i = 0; i < list.getAssetCollection().getData().size(); i++) {
				final UploadToken uploadToken = list.getToken().get(i);
				final AssetModel asset = list.getAssetCollection().getData()
						.get(i);
				if (onProgressUpdate != null) {
					onProgressUpdate.onUploadStarted(asset,
							getThumbnailIfPossible(uploadToken));
				}
				ALog.d(TAG, "Reading Token");
				if (uploadToken != null && uploadToken.getUploadInfo() != null) {
					uploader.startUpload(uploadToken);
					ALog.d(TAG, "Calling upload complete");
					ALog.d(TAG, "Need to upload");

				}
				if (onProgressUpdate != null) {
					onProgressUpdate.onUploadFinished(asset);
				}
			}
			uploadComplete(context, list.getUploadId(),
					new UploadCompleteListener()).execute();
			handler.post(new Runnable() {

				@Override
				public void run() {
					callback.onSuccess(list.getAssetCollection());
				}
			});
		} catch (final Exception e) {
			Log.e(TAG, "Error in the Upload Request", e);
			handler.post(new Runnable() {

				@Override
				public void run() {
					callback.onHttpError(null);
				}
			});
		}
	}

	private Bitmap getThumbnailIfPossible(UploadToken uploadToken) {
		try {
			if (uploadToken == null) {
				return null;
			}
			if (uploadToken.getUploadInfo() == null) {
				return null;
			}
			return Utils.getThumbnailFromFilename(uploadToken.getUploadInfo()
					.getFilepath());
		} catch (Exception e) {
			Log.d(TAG, "", e);
		}
		return null;
	}

	private final class TokenListener implements
			HttpCallback<ResponseModel<UploadTokenResponse>> {

		@Override
		public void onSuccess(ResponseModel<UploadTokenResponse> responseData) {
			ALog.d("Success " + responseData.getData().toString());
			AssetsUploadRequest.this.list = responseData.getData();
			resumeThread();

		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			ALog.d("Error " + responseCode + " "
					+ responseCode.getStatusMessage());
			// super.onHttpError(responseCode, responseCode.getStatusMessage());
			resumeThread();

		}
	}

	private final class UploadCompleteListener implements HttpCallback<Void> {

		@Override
		public void onSuccess(final Void responseData) {
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			ALog.d("Error " + responseCode + " "
					+ responseCode.getStatusMessage());

		}
	}

	public static HttpRequest getToken(final Context context,
			final List<AssetModel> localAssetCollection,
			final ArrayList<String> chuteIds,
			final HttpCallback<ResponseModel<UploadTokenResponse>> callback) {
		return getToken(context, localAssetCollection, chuteIds, callback);
	}

	public static HttpRequest uploadComplete(final Context context,
			final String uploadId, final HttpCallback<Void> callback) {
		return new AssetsUploadCompleteRequest(context, uploadId, callback);
	}

	@Override
	public void executeAsync() {
		HttpRequestStore.getInstance(context).launchServiceIntent(this);
	}

}
