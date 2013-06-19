package com.chute.sdk.v2.api.upload;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileData implements Serializable {

	@JsonProperty("chutes")
	private List<String> chutes;
	@JsonProperty("files")
	private List<FileBean> files;

	public List<String> getChutes() {
		return chutes;
	}

	public void setChutes(List<String> chutes) {
		this.chutes = chutes;
	}

	public List<FileBean> getFiles() {
		return files;
	}

	public void setFiles(List<FileBean> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FileData [chutes=" + chutes + ", files=" + files + "]";
	}

}
