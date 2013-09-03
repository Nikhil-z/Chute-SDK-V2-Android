package com.chute.sdk.v2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a wrapper of {@link AccountAlbumModel} and
 * {@link AccountMediaModel}.
 * <p>
 * {@link AccountBaseModel} is returned every time a specific account call is
 * executed.
 */
public class AccountBaseModel {

  /**
   * List of media items.
   * <p>
   * Besides media items this list can also contain albums.
   */
  @JsonProperty("files")
  private List<AccountMediaModel> files;

  /**
   * List of albums
   * <p>
   * This list can also contain media items.
   */
  @JsonProperty("folders")
  private List<AccountAlbumModel> folders;

  /**
   * Getters and setters.
   */
  public List<AccountMediaModel> getFiles() {
    return files;
  }

  public void setFiles(List<AccountMediaModel> files) {
    this.files = files;
  }

  public List<AccountAlbumModel> getFolders() {
    return folders;
  }

  public void setFolders(List<AccountAlbumModel> folders) {
    this.folders = folders;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountBaseModel [files=");
    builder.append(files);
    builder.append(", folders=");
    builder.append(folders);
    builder.append("]");
    return builder.toString();
  }

}
