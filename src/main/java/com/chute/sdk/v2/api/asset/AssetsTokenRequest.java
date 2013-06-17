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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.api.upload.UploadTokenResponse;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;

public class AssetsTokenRequest extends StringBodyHttpRequestImpl<ResponseModel<UploadTokenResponse>> {
	private final ArrayList<AssetModel> assets;
	private final ArrayList<String> albumIds;

	public AssetsTokenRequest(final Context context,
			final ArrayList<AssetModel> assets,
			final ArrayList<String> albumIds,
			final HttpCallback<ResponseModel<UploadTokenResponse>> callback) {
		super(context, RequestMethod.POST,
				new ResponseParser<UploadTokenResponse>(
						UploadTokenResponse.class), callback);
		this.assets = assets;
		this.albumIds = albumIds;
	}

	public static final String TAG = AssetsTokenRequest.class.getSimpleName();



	@Override
	public String bodyContents() {
//		final JSONObject root = new JSONObject();
//		final JSONObject dataObject = new JSONObject();
//		final JSONArray filesArray = new JSONArray();
//		try {
//			final JSONObject obj = new JSONObject();
//			for (final GCLocalAssetModel asset : ac) {
//				obj.put("filename", asset.getFile().getPath());
//				obj.put("md5", asset.calculateFileMD5());
//				obj.put("size", asset.getSize());
//				if (TextUtils.isEmpty(asset.getIdentifier()) == false) {
//					obj.put("type", asset.getIdentifier());
//				}
//				Log.d(TAG, ac.toString());
//				filesArray.put(obj);
//			}
//			dataObject.put("files", filesArray);
//			// Add Chutes
//			final JSONArray chutesArray = new JSONArray(chuteIds);
//			dataObject.put("chutes", chutesArray);
//			root.put("data", dataObject);
//			setBody(root.toString());
//		} catch (final JSONException e) {
//			Logger.d(TAG, "", e);
//		}
		return null;
	}

	@Override
	protected String getUrl() {
		return RestConstants.URL_UPLOAD_TOKEN;
	}
}
