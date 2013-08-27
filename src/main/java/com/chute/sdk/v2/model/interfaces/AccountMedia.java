package com.chute.sdk.v2.model.interfaces;

import com.chute.sdk.v2.model.enums.AccountMediaType;


public interface AccountMedia {
  
  public AccountMediaType getViewType();
  
  public String getName();

  public String getThumbnail();

}
