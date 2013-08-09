package com.chute.sdk.v2.api.accounts;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AccountMediaModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

class AccountAlbumMediaRequest extends ParameterHttpRequestImpl<ListResponseModel<AccountMediaModel>> {

	public static final String TAG = AccountAlbumMediaRequest.class.getSimpleName();
	private final String accountShortcut;
	private final String objectId;

	public AccountAlbumMediaRequest(Context context, String accountShortcut, String objectId,
			HttpCallback<ListResponseModel<AccountMediaModel>> callback) {
		super(context, RequestMethod.GET, new ListResponseParser<AccountMediaModel>(AccountMediaModel.class), callback);
		this.accountShortcut = accountShortcut;
		if (TextUtils.isEmpty(objectId)) {
			throw new NullPointerException("Need to provide object ID");
		}
		this.objectId = objectId;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ACCOUNT_MEDIA, accountShortcut, objectId);
	}

}
