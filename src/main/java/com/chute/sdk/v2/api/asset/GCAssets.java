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
import java.util.HashMap;

import android.content.Context;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.PaginationModel;
import com.chute.sdk.v2.model.enums.Filter;
import com.chute.sdk.v2.model.enums.Sort;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCAssets} class is a helper class for managing {@link AssetModel}.
 * The API enables users and developers to access the following methods:
 * getting, uploading, importing, updating and deleting assets, retrieving
 * asset's exif and geo-location data, getting and updating asset's caption, as
 * well as getting and updating all tags associated within an asset.
 * 
 */
public class GCAssets {

	@SuppressWarnings("unused")
	private static final String TAG = GCAssets.class.getSimpleName();

	/**
	 * A private no-args default constructor.
	 */
	private GCAssets() {
		super();
	}

	/**
	 * Uploads new assets from the local storage
	 * 
	 * @param context
	 *            - The application context
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link AssetsUploadRequest}
	 */
	public static HttpRequest upload(final Context context,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsUploadRequest(context, callback);
	}

/**
	 * Imports asset(s) by providing an existing URL targeting the specific
	 * media item. Imported assets this way won’t belong to an album. You can
	 * use {@see #GCAlbums.Assets.add(Context, AlbumModel, ArrayList<String>, HttpCallback<ResponseModel<AlbumModel>>) to add assets to one or multiple albums
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album containing assets for import
	 * @param urls
	 *            - List of asset URLs to be imported
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link AssetsImportRequest}
	 */
	public static HttpRequest imports(final Context context,
			final ArrayList<String> urls,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AssetsImportRequest(context, urls, callback);
	}

	/**
	 * Gets exif info for an asset. Empty if there are no available exif
	 * parameters.
	 * 
	 * @param context
	 *            - The application context
	 * @param asset
	 *            - Asset containing exif data to be retrieved
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link AssetsExifRequest}
	 */
	public static HttpRequest exif(final Context context,
			final AssetModel asset,
			final HttpCallback<ResponseModel<HashMap<String, String>>> callback) {
		return new AssetsExifRequest(context, asset, callback);
	}

	/**
	 * Deletes an asset using its ID
	 * 
	 * @param context
	 *            - The application context
	 * @param asset
	 *            - The asset to be removed
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link AssetsDeleteRequest}
	 */
	public static HttpRequest delete(final Context context,
			final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsDeleteRequest(context, asset, callback);
	}

	/**
	 * Updates the caption (description text) on an asset
	 * 
	 * @param context
	 *            - The application context
	 * @param asset
	 *            - The asset to be updated
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link AssetsUpdateRequest}
	 */
	public static HttpRequest update(final Context context,
			final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsUpdateRequest(context, asset, callback);
	}

	/**
	 * Gets a specific asset from a given album
	 * 
	 * @param context
	 *            The application context
	 * @param album
	 *            Album whose asset we are demanding
	 * @param asset
	 *            The requested asset
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}
	 * @return {@link AlbumsGetAssetRequest}
	 */
	public static HttpRequest get(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetRequest(context, album, asset, callback);
	}

	/**
	 * Gets a list of assets from a specific album
	 * 
	 * @param context
	 *            The application context
	 * @param album
	 *            The album whose assets are being retrieved
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ListResponseModel<AssetModel>}
	 * @return {@link AlbumsGetAssetListRequest}
	 */
	public static HttpRequest list(final Context context,
			final AlbumModel album, PaginationModel pagination,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetListRequest(context, album, pagination,
				callback);
	}

	/**
	 * Overloaded method
	 * 
	 * @see #list(Context, AlbumModel, PaginationModel, HttpCallback)
	 * 
	 * @param context
	 * @param album
	 * @param callback
	 * @return
	 */
	public static HttpRequest list(final Context context,
			final AlbumModel album,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetListRequest(context, album,
				new PaginationModel(), callback);
	}

}