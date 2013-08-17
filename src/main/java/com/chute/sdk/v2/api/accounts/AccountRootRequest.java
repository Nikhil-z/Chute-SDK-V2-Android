package com.chute.sdk.v2.api.accounts;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.enums.AccountType;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

class AccountRootRequest extends ParameterHttpRequestImpl<ListResponseModel<AccountBaseModel>> {

	public static final String TAG = AccountRootRequest.class.getSimpleName();
	private final String accountShortcut;
	private final AccountType accountType;

	public AccountRootRequest(Context context, AccountType accountType, String accountShortcut, 
			HttpCallback<ListResponseModel<AccountBaseModel>> callback) {
		super(context, RequestMethod.GET, new ListResponseParser<AccountBaseModel>(AccountBaseModel.class), callback);
		if (TextUtils.isEmpty(accountShortcut)) {
			throw new NullPointerException("Need to provide account shortcut");
		}
		this.accountShortcut = accountShortcut;
		this.accountType = accountType;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.URL_ACCOUNT_ROOT, accountType.getName(), accountShortcut);
	}

}