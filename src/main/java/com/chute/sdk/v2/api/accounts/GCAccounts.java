package com.chute.sdk.v2.api.accounts;

import android.content.Context;

import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCAccounts} is a helper class that contains static methods for:
 * <ul>
 * <li>Getting all user accounts
 * <li>Getting a list of albums for a specific account
 * <li>Getting a list of media items from an album
 * </ul>
 */
public class GCAccounts {

  public static final String TAG = GCAccounts.class.getSimpleName();

  /**
   * Method used for getting accounts.
   * <p>
   * Returns JSon object containing list of accounts using context and given
   * callback.
   * 
   * @param context
   *          The application context.
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ListResponseModel} containing list of accounts.
   * @return Instance of {@link CurrentUserAccountsRequest}, class that
   *         implements {@link GCHttpRequest}.
   */
  public static HttpRequest allUserAccounts(final Context context,
      final HttpCallback<ListResponseModel<AccountModel>> callback) {
    return new CurrentUserAccountsRequest(context, callback);
  }

  /**
   * Gets list of albums and media items for a specific account.
   * 
   * @param context
   *          Application context.
   * @param accountName
   *          Account name.
   *          <p>
   *          It can be: facebook, flickr, instagram, picasa, google,
   *          googledrive, skydrive or dropbox
   * @param accountId
   *          Account ID.
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ResponseModel} containing {@link AccountBaseModel}.
   * @return Instance of {@link AccountRootRequest}, class that implements
   *         {@link GCHttpRequest}.
   */
  public static HttpRequest accountRoot(final Context context, final String accountName,
      final String accountId,
      final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
    return new AccountRootRequest(context, accountName, accountId, callback);
  }

  /**
   * Returns all immediate subfolders and items of the parent folder.
   * 
   * @param context
   *          Application context.
   * @param accountName
   *          Account name.
   *          <p>
   *          It can be: facebook, flickr, instagram, picasa, google,
   *          googledrive, skydrive or dropbox
   * @param accountId
   *          Account ID.
   * @param folderId
   *          Account album ID.
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ResponseModel} containing {@link AccountBaseModel}.
   * @return Instance of {@link AccountSingleRequest}, class that implements
   *         {@link GCHttpRequest}.
   */
  public static HttpRequest accountSingle(final Context context,
      final String accountName, final String accountId,
      final String folderId, final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
    return new AccountSingleRequest(context, accountName, accountId, folderId, callback);
  }
}
