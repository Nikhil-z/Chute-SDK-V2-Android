package com.chute.sdk.v2.api.base;

import android.content.Context;

import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.parsers.HttpResponseParser;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;


public class PageRequest<T> extends ParameterHttpRequestImpl<T>{

  private String url;

  public PageRequest(Context context, RequestMethod requestMethod, String url,
      HttpResponseParser<T> parser, HttpCallback<T> callback) {
    super(context, requestMethod, parser, callback);
    this.url = url;
  }

  public static final String TAG = PageRequest.class.getSimpleName();

  @Override
  protected String getUrl() {
    return url;
  }

}
