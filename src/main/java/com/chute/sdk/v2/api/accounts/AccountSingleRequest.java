package com.chute.sdk.v2.api.accounts;

import android.content.Context;
import android.text.TextUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.enums.AccountType;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

class AccountSingleRequest extends ParameterHttpRequestImpl<ResponseModel<AccountBaseModel>> {

	public static final String TAG = AccountSingleRequest.class.getSimpleName();
	private final String accountShortcut;
	private final AccountType accountType;
	private final String folderId;

	public AccountSingleRequest(Context context, AccountType accountType, String accountShortcut, String folderId,
			HttpCallback<ResponseModel<AccountBaseModel>> callback) {
		super(context, RequestMethod.GET, new ResponseParser<AccountBaseModel>(AccountBaseModel.class), callback);
		if (TextUtils.isEmpty(accountShortcut)) {
			throw new NullPointerException("Need to provide account shortcut");
		}
		this.accountShortcut = accountShortcut;
		this.accountType = accountType;
		this.folderId = folderId;
	}

	@Override
	protected String getUrl() {
//		return String.format(RestConstants.URL_ACCOUNT_SINGLE, accountType.getName(), accountShortcut, folderId);
		return "https://dl.dropboxusercontent.com/u/23635319/ChuteAPI/files.json";
	}

}
