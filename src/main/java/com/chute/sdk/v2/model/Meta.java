package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link Meta} class wraps up information regarding protocol version and error
 * code.
 * 
 */
public class Meta {

	/**
	 * Protocol version
	 */
	@JsonProperty("version")
	private int version;

	/**
	 * Error code
	 */
	@JsonProperty("code")
	private int code;

	/**
	 * Getters and setters
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meta [version=" + version + ", code=" + code + "]";
	}

}
