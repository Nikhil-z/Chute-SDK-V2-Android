package com.chute.sdk.v2.api.accounts;

import android.content.Context;

import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.AccountMediaModel;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.AccountAlbumModel;
import com.chute.sdk.v2.model.enums.AccountType;
import com.chute.sdk.v2.model.response.ListResponseModel;
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

	/**
	 * Method used for getting list of object for a specific account. It returns
	 * a JSon object using the following parameters: context, string value, the
	 * given callback and parser.
	 * 
	 * @param context
	 *            The application context.
	 * @param accountId
	 *            {@link AccountModel} ID, representing the specific account.
	 * @param parser
	 *            Instance of {@link GCHttpResponseParser} interface. You can
	 *            add a custom parser or use the parser provided here {@see
	 *            #objectMedia(Context, String, String, GCHttpCallback)}.
	 * @param callback
	 *            Instance of {@link GCHttpCallback} interface. According to the
	 *            parser, the callback should have the same return type.
	 * @return Instance of {@link AccountAlbumsRequest}, class that implements
	 *         {@link GCHttpRequest}.
	 */
	public static HttpRequest albums(final Context context, final String accountId,
			final HttpCallback<ListResponseModel<AccountAlbumModel>> callback) {
		return new AccountAlbumsRequest(context, accountId, callback);
	}

	/**
	 * Method used for getting media items for a specific object. It returns
	 * JSon object using the following parameters: context, string values, the
	 * given callback and parser.
	 * 
	 * @param context
	 *            The application context.
	 * @param accountId
	 *            {@link AccountModel} ID, representing the specific account.
	 * @param objectId
	 *            {@link AccountAlbumModel} ID, representing the specific object
	 *            from an account.
	 * @param parser
	 *            Instance of {@link GCHttpResponseParser} interface. You can
	 *            add a custom parser or use the parser provided here {@see
	 *            #objectMedia(Context, String, String, GCHttpCallback)}.
	 * @param callback
	 *            Instance of {@link GCHttpCallback} interface. According to the
	 *            parser, the callback should have the same return type.
	 * @return Instance of {@link AccountAlbumMediaRequest}, class that
	 *         implements {@link GCHttpRequest}.
	 */
	public static HttpRequest albumMedia(final Context context, final String accountId, final String objectId,
			final HttpCallback<ListResponseModel<AccountMediaModel>> callback) {
		return new AccountAlbumMediaRequest(context, accountId, objectId, callback);
	}

	public static HttpRequest accountRoot(final Context context, final AccountType accountType, final String accountId,
			final HttpCallback<ListResponseModel<AccountBaseModel>> callback) {
		return new AccountRootRequest(context, accountType, accountId, callback);
	}

	public static HttpRequest accountSingle(final Context context, final AccountType accountType,
			final String accountId, final String folderId,
			final HttpCallback<ListResponseModel<AccountBaseModel>> callback) {
		return new AccountSingleRequest(context, accountType, accountId, folderId, callback);
	}
}
