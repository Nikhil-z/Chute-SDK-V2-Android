package com.chute.sdk.v2.api.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

	@JsonProperty("version")
	private int version;
	@JsonProperty("code")
	private int code;

	public Meta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Meta [version=" + version + ", code=" + code + "]";
	}

}
