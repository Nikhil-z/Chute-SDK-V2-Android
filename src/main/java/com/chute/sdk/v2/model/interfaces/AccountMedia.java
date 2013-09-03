package com.chute.sdk.v2.model.interfaces;

import com.chute.sdk.v2.model.AccountAlbumModel;
import com.chute.sdk.v2.model.AccountMediaModel;
import com.chute.sdk.v2.model.enums.AccountMediaType;

/**
 * This interface is implemented by {@link AccountMediaModel} and
 * {@link AccountAlbumModel} indicating whether the class is a representation of
 * an album or a media item.
 * 
 */
public interface AccountMedia {

  /**
   * Gets the type of the view. It can be a file or a folder.
   * <p>
   * {@link AccountAlbumModel} is presented as a folder whereas
   * {@link AccountMediaModel} as an asset.
   * 
   * @return {@link AccountMediaType}
   */
  public AccountMediaType getViewType();

  /**
   * 
   * @return Name of the folder or file.
   */
  public String getName();

}
