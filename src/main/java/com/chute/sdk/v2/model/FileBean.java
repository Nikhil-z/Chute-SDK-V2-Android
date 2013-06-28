package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents the concept of a file consisting of MD5, name of the
 * file and file size.
 * 
 */
public class FileBean {

	/**
	 * File MD5
	 */
	@JsonProperty("md5")
	private String md5;

	/**
	 * Name of the file
	 */
	@JsonProperty("filename")
	private String fileName;

	@JsonProperty("size")
	private String size;

	/**
	 * Getters and setters
	 */
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
		StringBuilder builder = new StringBuilder();
		builder.append("FileBean [md5=");
		builder.append(md5);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}

}
