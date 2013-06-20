package com.chute.sdk.v2.api.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileObject {

	@JsonProperty("data")
	private FileData data;

	public FileData getData() {
		return data;
	}

	public void setData(FileData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileObject [data=" + data + "]";
	}

}
