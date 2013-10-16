package com.chute.sdk.v2.model;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.model.interfaces.Storeable;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

public class StoreValueModel implements Storeable {

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("StoreValueModel [id=");
    builder.append(id);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public String fromObjectToJson() {
    try {
      return JsonUtil.getMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
      ALog.e(e);
    }
    return "";
  }

}
