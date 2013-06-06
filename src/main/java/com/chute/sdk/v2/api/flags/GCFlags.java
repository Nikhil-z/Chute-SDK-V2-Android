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
package com.chute.sdk.v2.api.flags;

import android.content.Context;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCFlags} class is a helper class which contains methods for
 * manipulating with flags: getting, deleting and creating asset flags.
 * 
 */
public class GCFlags {

	public static final String TAG = GCFlags.class.getSimpleName();

	/**
	 * Default non-args constructor
	 */
	public GCFlags() {
	}

	/**
	 * Flags a specific asset inside an album. The asset will be marked for the
	 * current user doing the requests.
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album that contains the flagged asset
	 * @param asset
	 *            - The asset to be flagged
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<FlagModel>}
	 * @return - {@link FlagGetRequest}
	 */
	public static HttpRequest flag(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<FlagModel>> callback) {
		return new FlagRequest(context, album, asset, callback);
	}

	/**
	 * Pulls a complete count of all flags associated with an asset inside an
	 * album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album that holds the flagged asset
	 * @param asset
	 *            - Flagged asset
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<FlagModel>}
	 * @return - {@link FlagGetRequest}
	 */
	public static HttpRequest get(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<FlagModel>> callback) {
		return new FlagGetRequest(context, album, asset, callback);
	}


	/**
	 * Unflags a specific asset inside an album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album that holds the flagged asset
	 * @param asset
	 *            - Flagged asset
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<FlagModel>}
	 * @return - {@link UnflagRequest}
	 */
	public static HttpRequest unflag(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<FlagModel>> callback) {
		return new UnflagRequest(context, album, asset, callback);

	}
}
