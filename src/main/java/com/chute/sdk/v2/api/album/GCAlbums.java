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

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCAlbums} class is a helper class that contains methods regarding
 * {@link AlbumModel}. The API enables users and developers to access the
 * following methods: creating, deleting, editing albums, getting an asset or a
 * list of assets from a specific album.
 * 
 */
public class GCAlbums {
	public static final String TAG = GCAlbums.class.getSimpleName();

	/**
	 * A private no-args default constructor.
	 */
	private GCAlbums() {
	}

	/**
	 * Pulls a complete list of all the albums accessible to the user
	 * 
	 * @param context
	 *            - The application context
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ListResponseModel<AlbumModel>}
	 * @return - {@link AlbumsListRequest}
	 */
	public static HttpRequest list(final Context context,
			final HttpCallback<ListResponseModel<AlbumModel>> callback) {
		return new AlbumsListRequest(context, callback);
	}

	/**
	 * Retrieves details of a specific album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album to be retrieved
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AlbumModel>}
	 * @return - {@link AlbumsGetRequest}
	 */
	public static HttpRequest get(final Context context,
			final AlbumModel album,
			final HttpCallback<ResponseModel<AlbumModel>> callback) {
		return new AlbumsGetRequest(context, album, callback);
	}

	/**
	 * Creates an album. Sending additional defined parameters will enable you
	 * to customize name, privileges, visibility, moderation etc…
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album to be created
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AlbumModel>}
	 * @return - {@link AlbumsCreateRequest}
	 */
	public static HttpRequest create(final Context context,
			final AlbumModel album,
			final HttpCallback<ResponseModel<AlbumModel>> callback) {
		return new AlbumsCreateRequest(context, album, callback);
	}

	/**
	 * Updates existing album properties
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album to be edited
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AlbumModel>}
	 * @return - {@link AlbumsUpdateRequest}
	 */
	public static HttpRequest update(final Context context,
			final AlbumModel album,
			final HttpCallback<ResponseModel<AlbumModel>> callback) {
		return new AlbumsUpdateRequest(context, album, callback);
	}

	/**
	 * Deletes an album. Deletion will occur only if the user has the
	 * appropriate permission to delete the album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album to be deleted
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AlbumModel>}
	 * @return - {@link AlbumsDeleteRequest}
	 */
	public static HttpRequest delete(final Context context,
			final AlbumModel album,
			final HttpCallback<ResponseModel<AlbumModel>> callback) {
		return new AlbumsDeleteRequest(context, album, callback);
	}

	/**
	 * Imports assets inside albums
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - Album needed to place the imported assets
	 * @param urls
	 *            - List of desired asset URLs for import
	 * @param callback
	 *            -Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ListResponseModel<AssetModel>}
	 * @return - {@link AlbumsImportRequest}
	 */
	public static HttpRequest imports(final Context context,
			final AlbumModel album, final ArrayList<String> urls,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AlbumsImportRequest(context, album, urls, callback);
	}

	/**
	 * The {@link GCAlbums.Assets} class is an inner class which contains
	 * methods for getting a specific asset out of an album or a list of assets
	 * 
	 */
	public static class Assets {

		/**
		 * Adds existing assets to an album. The assets must be already created
		 * by upload or import.
		 * 
		 * @param context
		 *            - The application context
		 * @param album
		 *            - Album that holds the added assets
		 * @param assetIds
		 *            - List of asset IDs we want to add to an album
		 * @param callback
		 *            - Instance of {@link HttpCallback} interface. If
		 *            successful, the callback returns {@link ResponseModel
		 *            <Void>}
		 * @return - {@link AlbumsAddAssetsRequest}
		 */
		public static HttpRequest add(final Context context,
				final AlbumModel album, final ArrayList<String> assetIds,
				final HttpCallback<Void> callback) {
			return new AlbumsAddAssetsRequest(context, album, assetIds,
					callback);
		}

		/**
		 * Removes existing assets attached to an existing album
		 * 
		 * @param context
		 *            - The application context
		 * @param album
		 *            - Album that holds the assets for removal
		 * @param assetIds
		 *            - List of asset IDs we want to delete from the given album
		 * @param callback
		 *            - Instance of {@link HttpCallback} interface. If
		 *            successful, the callback returns {@link ResponseModel
		 *            <Void>}
		 * @return - {@link AlbumsRemoveAssetsRequest}
		 */
		public static HttpRequest remove(final Context context,
				final AlbumModel album, final ArrayList<String> assetIds,
				final HttpCallback<Void> callback) {
			return new AlbumsRemoveAssetsRequest(context, album, assetIds,
					callback);
		}

	}

}
