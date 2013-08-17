package com.chute.sdk.v2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBaseModel {

	@JsonProperty("files")
	private List<AccountMediaModel> files;

	@JsonProperty("folders")
	private List<AccountAlbumModel> folders;

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
