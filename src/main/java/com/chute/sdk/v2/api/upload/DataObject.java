package com.chute.sdk.v2.api.upload;

public class DataObject {

	private FilesArray data;

	public FilesArray getData() {
		return data;
	}

	public void setData(FilesArray data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataObject [data=" + data + "]";
	}

}
