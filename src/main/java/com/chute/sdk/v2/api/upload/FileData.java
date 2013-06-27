package com.chute.sdk.v2.api.upload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileData {

	@JsonProperty("files")
	private List<FileBean> files;

	@JsonProperty("chutes")
	private List<String> chutes;

	public List<FileBean> getFiles() {
		return files;
	}

	public void setFiles(List<FileBean> files) {
		this.files = files;
	}

	public List<String> getChutes() {
		return chutes;
	}

	public void setChutes(List<String> chutes) {
		this.chutes = chutes;
	}

	@Override
	public String toString() {
		return "FileData [files=" + files + ", chutes=" + chutes + "]";
	}

}
