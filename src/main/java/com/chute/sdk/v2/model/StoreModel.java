package com.chute.sdk.v2.model;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.araneaapps.android.libs.logger.ALog;
import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

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

  public StoreValueModel getStorageValue() {
    ObjectMapper mapper = JsonUtil.getMapper();
    StoreValueModel storeModel = null;
    try {
      storeModel = mapper.readValue(value, mapper.constructType(StoreValueModel.class));
    } catch (JsonParseException e) {
      ALog.d("JsonParseException: " + e.getMessage());
    } catch (JsonMappingException e) {
      ALog.d("JsonMappingException: " + e.getMessage());
    } catch (IOException e) {
      ALog.d("IOException: " + e.getMessage());
    }
    return storeModel;

  }

}
