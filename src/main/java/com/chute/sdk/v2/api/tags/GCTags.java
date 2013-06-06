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
package com.chute.sdk.v2.api.tags;

import java.util.ArrayList;

import android.content.Context;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * Tags are meta information placed on an asset. This kind of metadata helps
 * describe an item and allows it to be displayed by browsing or searching. Tags
 * are generally chosen informally and personally by the item’s creator or by
 * its viewer, depending on the client implementation. The API enables using the
 * following methods for manipulating with tags: getting, updating, deleting and
 * creating tags.
 * 
 */
public class GCTags {

	public static final String TAG = GCTags.class.getSimpleName();

	/**
	 * Default non-args constructor
	 */
	public GCTags() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Pulls a complete list of all tags associated with an asset inside an
	 * album
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album containing the asset with tags that are about to
	 *            be listed
	 * @param asset
	 *            - The asset containing the specific tags
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link TagsListRequest}
	 */
	public static HttpRequest list(final Context context,
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ListResponseModel<String>> callback) {
		return new TagsListRequest(context, album, asset, callback);
	}

	/**
	 * Replaces all existing tags within an asset with a new set of tags
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album containing the asset with tags that are about to
	 *            be updated
	 * @param asset
	 *            - The asset containing the specific tags
	 * @param tags
	 *            - List of new tags
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AssetModel>}
	 * @return - {@link TagsReplaceRequest}
	 */
	public static HttpRequest update(final Context context,
			final AlbumModel album, final AssetModel asset,
			final ArrayList<String> tags,
			final HttpCallback<ListResponseModel<String>> callback) {
		return new TagsReplaceRequest(context, album, asset, tags, callback);
	}

	/**
	 * Adds more tags attached to an asset inside an album. The asset will not
	 * share the tags between albums. Tags added will apply only to a specific
	 * asset inside an album.
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album containing the asset that will hold the newly
	 *            created tags
	 * @param asset
	 *            - The asset containing the newly created tags
	 * @param tags
	 *            - List of tags to be added
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ListResponseModel<String>}
	 * @return - {@link TagsAddRequest}
	 */
	public static HttpRequest create(final Context context,
			final AlbumModel album, final AssetModel asset,
			final ArrayList<String> tags,
			final HttpCallback<ListResponseModel<String>> callback) {
		return new TagsAddRequest(context, album, asset, tags, callback);
	}

	/**
	 * Deletes tags from an asset by using tag names. This will modify the
	 * existing tag array attached to an asset
	 * 
	 * @param context
	 *            - The application context
	 * @param album
	 *            - The album containing the asset whose tags are about to be
	 *            deleted
	 * @param asset
	 *            - The asset whose tags are about to be deleted
	 * @param tags
	 *            - List of tags for removal
	 * @param callback
	 *            - Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ListResponseModel<String>}
	 * @return - {@link TagsDeleteRequest}
	 */
	public static HttpRequest delete(final Context context,
			final AlbumModel album, final AssetModel asset,
			final ArrayList<String> tags,
			final HttpCallback<ListResponseModel<String>> callback) {
		return new TagsDeleteRequest(context, album, asset, tags, callback);
	}

}
