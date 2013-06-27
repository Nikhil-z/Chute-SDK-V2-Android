package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that wraps up a {@link FileData} object. Used for providing information
 * for the image to be uploaded such as: image name, MD5, size and ID of the
 * album that contains the image.
 * 
 */
public class FileObject {

	/**
	 * Image information wrapped in {@link FileData}
	 */
	@JsonProperty("data")
	private FileData data;

	/**
	 * Getter and setter
	 */
	public FileData getData() {
		return data;
	}

	public void setData(FileData data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileObject [data=" + data + "]";
	}

}
