package com.chute.sdk.v2.api.accounts;

import java.io.InputStream;

import android.content.Context;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.PreferenceUtil;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

class CurrentUserAccountsRequest extends
    ParameterHttpRequestImpl<ListResponseModel<AccountModel>> {

  public static final String TAG = CurrentUserAccountsRequest.class.getSimpleName();

  public CurrentUserAccountsRequest(final Context context,
      final HttpCallback<ListResponseModel<AccountModel>> callback) {
    super(context, RequestMethod.GET, new CurrentAccountsUserResponseParser(), callback);
  }

  @Override
  protected String getUrl() {
    return RestConstants.URL_ACCOUNTS;
  }

  private static class CurrentAccountsUserResponseParser extends
      ListResponseParser<AccountModel> {

    public CurrentAccountsUserResponseParser() {
      super(AccountModel.class);
    }

    @Override
    public ListResponseModel<AccountModel> parse(final InputStream responseBody)
        throws Exception {
      final ListResponseModel<AccountModel> responseModel = super.parse(responseBody);
      if (PreferenceUtil.isInitialized()) {
        for (final AccountModel account : responseModel.getData()) {
          PreferenceUtil.get().saveAccount(account);
        }
      }
      return responseModel;
    }

  }
}
