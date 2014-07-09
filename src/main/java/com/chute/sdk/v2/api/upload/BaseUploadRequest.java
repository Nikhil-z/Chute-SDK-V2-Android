package com.chute.sdk.v2.api.upload;

import com.araneaapps.android.libs.asyncrunners.models.RequestOptions;
import com.araneaapps.android.libs.asyncrunners.models.TaskStore;
import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.api.upload.CountingMultipartRequestEntity.ProgressListener;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.dg.libs.rest.RestClientConfiguration;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.EntityHttpRequestImpl;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;

public abstract class BaseUploadRequest extends
		EntityHttpRequestImpl<ListResponseModel<AssetModel>> implements
		ProgressListener {

	private final UploadProgressListener uploadListener;
	private final File file;
	private final CountingMultipartRequestEntity countingMultipartRequestEntity;

	public BaseUploadRequest(String filePath,
			UploadProgressListener uploadListener,
			HttpCallback<ListResponseModel<AssetModel>> callback) {
		super(RequestMethod.POST, new ListResponseParser<AssetModel>(
				AssetModel.class), callback);
		this.uploadListener = uploadListener;
		this.file = new File(filePath);
		MultipartEntity multipartEntity = null;
		try {
			multipartEntity = new MultipartEntity();
			multipartEntity
					.addPart(getMultipartEntityKey(), new FileBody(file));
			countingMultipartRequestEntity = new CountingMultipartRequestEntity(
					multipartEntity, this);
		} catch (Exception e) {
			ALog.d("Multipart Entitiy Exception = " + e.getMessage(), e);
			throw new IllegalArgumentException("Unable to create entity");
		}
	}

	public abstract String getMultipartEntityKey();

	public void cancel() {
		countingMultipartRequestEntity.cancel();
	}

	@Override
	public HttpEntity getEntity() {
		return countingMultipartRequestEntity;
	}

	@Override
	public void transferred(long num) {
		uploadListener.onProgress(file.length(), num);
	}

	@Override
	protected void doBeforeRunRequestInBackgroundThread() {
		super.doBeforeRunRequestInBackgroundThread();
		if (uploadListener != null) {
			uploadListener.onUploadStarted(file);
		}
	}

	@Override
	protected void doAfterRunRequestInBackgroundThread() {
		super.doAfterRunRequestInBackgroundThread();
		if (uploadListener != null) {
			uploadListener.onUploadFinished(file);
		}
	}

	@Override
	public void executeAsync() {
		RequestOptions requestOptions = new RequestOptions.RequestOptionsBuilder().setRunInSingleThread(true).build();
		TaskStore.get(RestClientConfiguration.get().getContext()).queue(this,
				requestOptions);
	}

}
