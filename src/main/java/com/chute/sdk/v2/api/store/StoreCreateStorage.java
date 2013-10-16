package com.chute.sdk.v2.api.store;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.StoreModel;
import com.chute.sdk.v2.model.StoreValueModel;
import com.chute.sdk.v2.model.enums.StoreType;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;

public class StoreCreateStorage extends
    StringBodyHttpRequestImpl<ResponseModel<StoreModel>> {

  private final StoreType type;
  private final String key;
  private final StoreValueModel value;

  public StoreCreateStorage(Context context, final StoreType type, final String key,
      final StoreValueModel value,
      HttpCallback<ResponseModel<StoreModel>> callback) {
    super(context, RequestMethod.POST, new ResponseParser<StoreModel>(StoreModel.class),
        callback);
    if (type == null) {
      throw new IllegalArgumentException("Need to provide storage type");
    }
    if (value == null ) {
      throw new IllegalArgumentException("Need to provide list of value strings");
    }
    this.type = type;
    this.key = key;
    this.value = value;
    addParam("Content-Type", "application/json");
  }

  @Override
  public String bodyContents() {
    return value.fromObjectToJson();
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_STORE, type.name().toLowerCase(), key);
  }

}
