package com.chute.sdk.v2.api.asset;

import java.io.File;

import android.content.Context;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.FileBodyHttpRequestImpl;

public class AssetsFileRequest extends FileBodyHttpRequestImpl<ResponseModel<String>> {

	private String filePath;
	private AlbumModel album;
	private String token;

	public AssetsFileRequest(Context context, AlbumModel album, String filePath, String token,
			HttpCallback<ResponseModel<String>> callback) {
		super(context, RequestMethod.POST, new ResponseParser<String>(String.class), callback);
		this.filePath = filePath;
		this.album = album;
		this.token = token;
		if (token == null) {
			throw new NullPointerException("Token cannot be null");
		}
		if (album == null) {
			throw new NullPointerException("Album cannot be null");
		}
		Log.d("debug", "request album id = " + album.getId());
		Log.d("debug", "request token = " + token);
		client.addHeader("Authorization", "Bearer " + token);
		Log.d("debug", "client headers = " + getClient().getHeaders().toString());
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
	
	
	
//	@Override
//	protected void doBeforeRunRequestInBackgroundThread() {
//		super.doBeforeRunRequestInBackgroundThread();
//		addHeader("Authorization", "Bearer " + token);
//		
//	}


}
