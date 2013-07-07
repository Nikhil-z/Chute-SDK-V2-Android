package com.chute.sdk.v2.api.asset;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.nio.charset.Charset;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import android.content.Context;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.FileBodyHttpRequestImpl;

public class AssetsFileRequest extends FileBodyHttpRequestImpl<ListResponseModel<AssetModel>> {

	private String filePath;
	private AlbumModel album;

	public AssetsFileRequest(Context context, AlbumModel album, String filePath,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(context, RequestMethod.POST, new ListResponseParser<AssetModel>(AssetModel.class), callback);
		this.filePath = filePath;
		this.album = album;
		if (album == null) {
			throw new NullPointerException("Album cannot be null");
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public HttpEntity getEntity() {
		MultipartEntity multipartEntity = null;
		try {
			multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			// multipartEntity.addPart("filedata", new FileBody(fileToSend()));
			multipartEntity.addPart("filedata", new FileBody(((File) fileToSend()), "application/zip"));

			multipartEntity.addPart("filedata",
					new StringBody(fileToSend().toString(), "text/plain", Charset.forName("UTF-8")));
		} catch (Exception e) {
			Log.d("debug", "get entitiy = " + e.getLocalizedMessage(), e);
		}
		return multipartEntity;
	}

	@Override
	protected void doAfterRunRequestInBackgroundThread() {
		super.doAfterRunRequestInBackgroundThread();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			getEntity().writeTo(bytes);
			String content = bytes.toString();
			Log.d("debug", "entity = " + content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("debug", "io excepton = " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public File fileToSend() {
		File file = new File(filePath);
		return file;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_UPLOAD_ONE_STEP, album.getId());
	}

}
