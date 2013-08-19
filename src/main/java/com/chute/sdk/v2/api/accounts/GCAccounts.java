package com.chute.sdk.v2.api.accounts;

import android.content.Context;

import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCAccounts} is a helper class which contains methods for getting
 * accounts, list of objects for the specific account, as well as media items
 * for the specific object.
 * 
 */
public class GCAccounts {

	public static final String TAG = GCAccounts.class.getSimpleName();

	/**
	 * Method used for getting accounts. It returns a JSon object containing a
	 * list of accounts using the following parameters: context, given parser
	 * and given callback.
	 * 
	 * @param context
	 *            The application context.
	 * @param parser
	 *            Instance of {@link GCHttpResponseParser} interface. You can
	 *            add a custom parser or use the parser provided here {@see
	 *            #all(Context, GCHttpCallback)}.
	 * @param callback
	 *            Instance of {@link GCHttpCallback} interface. According to the
	 *            parser, the callback should have the same return type.
	 * @return Instance of {@link AccountsRequest}, class that implements
	 *         {@link GCHttpRequest}.
	 */
	public static HttpRequest allUserAccounts(final Context context,
			final HttpCallback<ListResponseModel<AccountModel>> callback) {
		return new AccountsRequest(context, callback);
	}

	public static HttpRequest accountRoot(final Context context, final String accountName, final String accountId,
			final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
		return new AccountRootRequest(context, accountName, accountId, callback);
	}

	public static HttpRequest accountSingle(final Context context, final String accountName, final String accountId,
			final String folderId, final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
		return new AccountSingleRequest(context, accountName, accountId, folderId, callback);
	}
}
