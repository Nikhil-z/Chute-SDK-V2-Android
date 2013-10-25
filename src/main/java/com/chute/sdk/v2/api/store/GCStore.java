package com.chute.sdk.v2.api.store;

import android.content.Context;

import com.chute.sdk.v2.model.StoreModel;
import com.chute.sdk.v2.model.enums.StoreType;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * Chute key-value storage.
 * 
 */
public class GCStore {

  private GCStore() {
  }

  /**
   * Gets list of values stored under specific key.
   * 
   * @param context
   *          The application context;
   * @param type
   *          Storage type: private or public.
   * @param key
   *          Key under which the values will be stored.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<StoreModel>}.
   * @return {@link StoreGetStorage}
   */
  public static HttpRequest get(final Context context, final StoreType type, String key,
      final HttpCallback<ResponseModel<StoreModel>> callback) {
    return new StoreGetStorage(context, type, key, callback);
  }

}
