package com.chute.sdk.v2.api.store;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.StoreModel;
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
  private final List<String> values;

  public StoreCreateStorage(Context context, final StoreType type, final String key,
      final List<String> values,
      HttpCallback<ResponseModel<StoreModel>> callback) {
    super(context, RequestMethod.POST, new ResponseParser<StoreModel>(StoreModel.class),
        callback);
    if (type == null) {
      throw new IllegalArgumentException("Need to provide storage type");
    }
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Need to provide list of value strings");
    }
    this.type = type;
    this.key = key;
    this.values = values;
    addParam("Content-Type", "application/json");
  }

  @Override
  public String bodyContents() {
    JSONObject jsonObject = new JSONObject();
    JSONArray array = new JSONArray();
    for (String value : values) {
      array.put(value);
    }
    try {
      jsonObject.put("data", array);
    } catch (JSONException e) {
      ALog.e("Json Exception: " + e.getMessage());
    }
    return jsonObject.toString();
  }

  @Override
  protected String getUrl() {
    return String.format(RestConstants.URL_STORE, type.name().toLowerCase(), key);
  }

}
