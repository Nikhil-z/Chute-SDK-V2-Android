package com.chute.sdk.v2.api.asset;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;

import android.content.Context;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.chute.sdk.v2.utils.Utils;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.EntityHttpRequestImpl;

public class AssetsFileUploadRequest extends EntityHttpRequestImpl<ListResponseModel<AssetModel>> {

	private String filePath;
	private AlbumModel album;
	
	/**
	 * 
	 * Charset
     *  Description
     *  US-ASCII	Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode character set
     *  ISO-8859-1  	ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1
     *  UTF-8	   Eight-bit UCS Transformation Format
     *  UTF-16BE	Sixteen-bit UCS Transformation Format, big-endian byte order
     *  UTF-16LE	Sixteen-bit UCS Transformation Format, little-endian byte order
     *  UTF-16	Sixteen-bit UCS Transformation Format, byte order identified by an optional byte-order mark
	 */

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
			byte[] imageByteArray = Utils.getBytesFromFile(file);
			InputStream is = new ByteArrayInputStream(imageByteArray);
			InputStreamBody part = new InputStreamBody(is, "droid4.jpg");
			multipartEntity.addPart("filedata", part);
		} catch (Exception e) {
			Log.d("debug", "multipart entitiy exception = " + e.getMessage(), e);
		}
		return multipartEntity;
	}

	// Log entity content
	@Override
	protected void doBeforeRunRequestInBackgroundThread() {
		super.doAfterRunRequestInBackgroundThread();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			getEntity().writeTo(bytes);
			String content = bytes.toString();
			Log.d("debug", "entity content = " + content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("debug", "io excepton = " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_UPLOAD_ONE_STEP, album.getId());
	}

}
