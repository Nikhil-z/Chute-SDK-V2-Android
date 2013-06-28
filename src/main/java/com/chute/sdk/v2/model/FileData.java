package com.chute.sdk.v2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that wraps up a list of album IDs and {@link FileBean} objects.
 * 
 */
public class FileData {

	/**
	 * List of files
	 */
	@JsonProperty("files")
	private List<FileBean> files;

	/**
	 * List of album IDs
	 */
	@JsonProperty("chutes")
	private List<String> chutes;

	/**
	 * Getters and setters
	 */
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
		StringBuilder builder = new StringBuilder();
		builder.append("FileData [files=");
		builder.append(files);
		builder.append(", chutes=");
		builder.append(chutes);
		builder.append("]");
		return builder.toString();
	}

}
