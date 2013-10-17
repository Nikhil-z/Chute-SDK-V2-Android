package com.chute.sdk.v2.api.store;

import android.content.Context;

import com.chute.sdk.v2.api.base.BaseStringBodyHttpRequest;
import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.StoreModel;
import com.chute.sdk.v2.model.enums.StoreType;
import com.chute.sdk.v2.model.interfaces.StoreableValue;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;

public class StoreCreateStorage extends
    BaseStringBodyHttpRequest<ResponseModel<StoreModel>> {

  private final StoreType type;
  private final String key;
  private final StoreableValue storeableValue;

  public StoreCreateStorage(Context context, final StoreType type, final String key,
      final StoreableValue storeableValue,
      HttpCallback<ResponseModel<StoreModel>> callback) {
    super(context, RequestMethod.POST, new ResponseParser<StoreModel>(StoreModel.class),
        callback);
    if (type == null) {
      throw new IllegalArgumentException("Need to provide storage type");
    }
    if (storeableValue == null) {
      throw new IllegalArgumentException("Need to provide storeable object as a value");
    }
    this.type = type;
    this.key = key;
    this.storeableValue = storeableValue;
  }

  @Override
  public String bodyContents() {
    return storeableValue.storeValueToJson();
  }

  @Override
  protected String getUrl() {
    String url = "";
    if (key == null) {
      /*
       * The server generates key for the indicated value
       */
      url = String.format(RestConstants.URL_STORE, type.name().toLowerCase());
    } else {
      /*
       * Use predefined key for the indicated value
       */
      url = String.format(RestConstants.URL_STORE_KEY, type.name().toLowerCase(), key);
    }
    return url;
  }

}
