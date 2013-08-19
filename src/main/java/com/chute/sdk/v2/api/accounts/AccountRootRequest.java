package com.chute.sdk.v2.api.accounts;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

class AccountRootRequest extends ParameterHttpRequestImpl<ResponseModel<AccountBaseModel>> {

	public static final String TAG = AccountRootRequest.class.getSimpleName();
	private final String accountShortcut;
	private final String accountName;

	public AccountRootRequest(Context context, String accountName, String accountShortcut, 
			HttpCallback<ResponseModel<AccountBaseModel>> callback) {
		super(context, RequestMethod.GET, new ResponseParser<AccountBaseModel>(AccountBaseModel.class), callback);
		if (TextUtils.isEmpty(accountShortcut)) {
			throw new NullPointerException("Need to provide account shortcut");
		}
		this.accountShortcut = accountShortcut;
		this.accountName = accountName;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ACCOUNT_ROOT, accountName, accountShortcut);
	}

}
