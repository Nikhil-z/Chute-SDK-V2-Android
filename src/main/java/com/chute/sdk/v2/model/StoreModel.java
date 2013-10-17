package com.chute.sdk.v2.model;

import java.io.IOException;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.model.interfaces.StoreableValue;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class StoreModel {

  @JsonProperty("id")
  private String id;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("updated_at")
  private String updatedAt;
  @JsonProperty("value")
  private String value;
  @JsonProperty("url")
  private String url;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("StoreModel [id=");
    builder.append(id);
    builder.append(", createdAt=");
    builder.append(createdAt);
    builder.append(", updatedAt=");
    builder.append(updatedAt);
    builder.append(", value=");
    builder.append(value);
    builder.append(", url=");
    builder.append(url);
    builder.append("]");
    return builder.toString();
  }

  public StoreableValue getStorageValue() {
    ObjectMapper mapper = JsonUtil.getMapper();
    mapper = mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
    StoreableValue storeValue = null;
    try {
      storeValue = mapper.readValue(value, mapper.constructType(StoreableValue.class));
    } catch (JsonParseException e) {
      ALog.d("JsonParseException: " + e.getMessage());
    } catch (JsonMappingException e) {
      ALog.d("JsonMappingException: " + e.getMessage());
    } catch (IOException e) {
      ALog.d("IOException: " + e.getMessage());
    }
    return storeValue;

  }

}
