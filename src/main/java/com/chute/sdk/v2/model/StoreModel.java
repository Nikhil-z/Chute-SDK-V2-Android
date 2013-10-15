package com.chute.sdk.v2.model;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.araneaapps.android.libs.logger.ALog;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  public List<String> getStorageValue() {
    List<String> valueList = new ArrayList<String>();
    try {
      JSONObject jsonValue = new JSONObject(value);
      JSONArray dataArray = jsonValue.getJSONArray("data");
      for (int i = 0; i < dataArray.length(); i++) {
        String arrayValue = dataArray.getString(i);
        valueList.add(arrayValue);
      }
    } catch (JSONException e) {
      ALog.e("JSON Exception: " + e.getMessage());
    }
    return valueList;

  }

}
