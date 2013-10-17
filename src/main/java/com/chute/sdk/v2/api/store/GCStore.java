package com.chute.sdk.v2.api.store;

import android.content.Context;

import com.chute.sdk.v2.model.StoreModel;
import com.chute.sdk.v2.model.enums.StoreType;
import com.chute.sdk.v2.model.interfaces.StoreableValue;
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

  /**
   * Stores values under defined key. If the key is not indicated, the server
   * generates a default one.
   * 
   * @param context
   *          The application context.
   * @param type
   *          Storage type: private or public.
   * @param key
   *          Key under which the values will be stored.
   * @param values
   *          List of string values to be stored.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<StoreModel>}.
   * @return {@link StoreCreateStorage}
   */
  public static HttpRequest create(final Context context, final StoreType type,
      String key, StoreableValue value,
      final HttpCallback<ResponseModel<StoreModel>> callback) {
    return new StoreCreateStorage(context, type, key, value, callback);
  }

  /**
   * Updates the values stored under a specific key.
   * 
   * @param context
   *          The application context.
   * @param type
   *          Storage type: private or public.
   * @param key
   *          Key identifying the values for update.
   * @param values
   *          List of string values for update.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<StoreModel>}.
   * @return {@link StoreUpdateStorage}
   */
  public static HttpRequest update(final Context context, final StoreType type,
      String key, StoreableValue value,
      final HttpCallback<ResponseModel<StoreModel>> callback) {
    return new StoreUpdateStorage(context, type, key, value, callback);
  }

  /**
   * Deletes a certain key under which unnecessary values are stored.
   * 
   * @param context
   *          The application context.
   * @param type
   *          Storage type: private or public.
   * @param key
   *          Key identifying the values for removal.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<StoreModel>}.
   * @return {@link StoreDeleteStorage}
   */
  public static HttpRequest delete(final Context context, final StoreType type,
      String key,
      final HttpCallback<ResponseModel<StoreModel>> callback) {
    return new StoreDeleteStorage(context, type, key, callback);
  }

}
