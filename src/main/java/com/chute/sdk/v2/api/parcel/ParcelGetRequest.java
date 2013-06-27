package com.chute.sdk.v2.api.parcel;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class ParcelGetRequest extends
		ParameterHttpRequestImpl<ResponseModel<ParcelModel>> {

	public static final String TAG = ParcelGetRequest.class.getSimpleName();
	private ParcelModel parcel;

	public ParcelGetRequest(Context context, ParcelModel parcel,
			HttpCallback<ResponseModel<ParcelModel>> callback) {
		super(context, RequestMethod.GET, new ResponseParser<ParcelModel>(
				ParcelModel.class), callback);
		if (parcel == null || TextUtils.isEmpty(parcel.getId())) {
			throw new IllegalArgumentException("Need to provide parcel ID");
		}
		this.parcel = parcel;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_PARCELS_GET, parcel.getId());
	}

}
