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
package com.chute.sdk.v2.api.hearts;

import android.content.Context;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link Hearts} class is a helper class which contains the following
 * methods for manipulating with asset hearts: getting, deleting and creating
 * hearts.
 * 
 */
public class Hearts {

	public static final String TAG = Hearts.class.getSimpleName();

	/**
	 * Default non-args constructor
	 */
	public Hearts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Hearts a specific asset inside an album. The heart will be marked for the
	 * current user committing the requests
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album that holds the hearted asset
	 * @param asset
	 *            - Asset to be hearted
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<HeartModel>}
	 * @return - {@link HeartRequest}
	 */
	public static HttpRequest heart(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<HeartModel>> callback) {
		return new HeartRequest(context, album, asset, callback);
	}

	/**
	 * Gets a number of all hearts associated with an asset inside an album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album that holds the hearted asset
	 * @param asset
	 *            - Hearted asset
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<HeartModel>}
	 * @return - {@link HeartGetRequest}
	 */
	public static HttpRequest get(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<HeartModel>> callback) {
		return new HeartGetRequest(context, album, asset, callback);
	}

	/**
	 * Removes an existing heart from an asset.The heart will be marked for the
	 * current user doing the requests
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album containing the hearted asset
	 * @param asset
	 *            - Hearted asset
	 * @param callback
	 *            -Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<HeartModel>}
	 * @return - {@link UnheartRequest}
	 */
	public static HttpRequest unheart(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<HeartModel>> callback) {
		return new UnheartRequest(context, album, asset, callback);
	}
}