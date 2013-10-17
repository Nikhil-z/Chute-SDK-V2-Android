package com.chute.sdk.v2.api.store;

import android.content.Context;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.StoreModel;
import com.chute.sdk.v2.model.enums.StoreType;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class StoreGetStorage extends ParameterHttpRequestImpl<ResponseModel<StoreModel>> {

  private final StoreType type;
  private final String key;

  public StoreGetStorage(final Context context, final StoreType type, final String key,
      final HttpCallback<ResponseModel<StoreModel>> callback) {
    super(context, RequestMethod.GET, new ResponseParser<StoreModel>(StoreModel.class),
        callback);
    if (type == null) {
      throw new IllegalArgumentException("Need to provide storage type");
    }
    if (key == null) {
      throw new IllegalArgumentException(
          "Need to provide the key of the value you wish to retrieve");
    }
    this.type = type;
    this.key = key;
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_STORE_KEY, type.name().toLowerCase(), key);
  }

}
