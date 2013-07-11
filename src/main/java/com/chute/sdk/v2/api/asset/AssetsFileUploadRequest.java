package com.chute.sdk.v2.api.asset;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import android.content.Context;
import android.util.Log;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.api.upload.CountingMultipartRequestEntity;
import com.chute.sdk.v2.api.upload.CountingMultipartRequestEntity.ProgressListener;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.EntityHttpRequestImpl;

public class AssetsFileUploadRequest extends EntityHttpRequestImpl<ListResponseModel<AssetModel>> implements ProgressListener {

	private String filePath;
	private AlbumModel album;

	public AssetsFileUploadRequest(Context context, AlbumModel album, String filePath,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.POST, new ListResponseParser<AssetModel>(AssetModel.class), callback);
		this.filePath = filePath;
		this.album = album;
		if (album == null) {
			throw new NullPointerException("Album cannot be null");
		}
	}

	@Override
	public HttpEntity getEntity() {
		File file = new File(filePath);
		MultipartEntity multipartEntity = null;
		try {
			multipartEntity = new MultipartEntity();
			multipartEntity.addPart("filedata",new FileBody(file));
			return new CountingMultipartRequestEntity(multipartEntity, this);
		} catch (Exception e) {
			Log.d("debug", "multipart entitiy exception = " + e.getMessage(), e);
		}
		throw new IllegalArgumentException("Unable to create entity");
	}

	
	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_UPLOAD_ONE_STEP, album.getId());
	}

	@Override
	public void transferred(long num) {
		ALog.d("Transfered: " + num);
	}

}
