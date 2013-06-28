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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meta [version=");
		builder.append(version);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
