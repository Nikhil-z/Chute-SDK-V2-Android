package com.chute.sdk.v2.api.base;

import android.content.Context;

import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.parsers.HttpResponseParser;
import com.dg.libs.rest.requests.StringBodyHttpRequestImpl;

public abstract class BaseStringBodyHttpRequest<T> extends StringBodyHttpRequestImpl<T> {

  public BaseStringBodyHttpRequest(Context context, RequestMethod requestMethod,
      HttpResponseParser<T> parser, HttpCallback<T> callback) {
    super(context, requestMethod, parser, callback);
    addHeader("Content-Type", "application/json");
  }

}
