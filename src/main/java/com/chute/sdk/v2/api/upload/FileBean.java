package com.chute.sdk.v2.api.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "md5", "filename", "size" })
public class FileBean {

	@JsonProperty("md5")
	private String md5;
	@JsonProperty("filename")
	private String fileName;
	@JsonProperty("size")
	private String size;

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "FileBean [md5=" + md5 + ", fileName=" + fileName + ", size="
				+ size + "]";
	}

	
}
