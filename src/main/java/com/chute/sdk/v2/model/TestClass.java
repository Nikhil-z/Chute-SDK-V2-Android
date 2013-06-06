package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonRawValue;


public class TestClass {

	public static final String TAG = TestClass.class.getSimpleName();
	@JsonRawValue
	private String camera;
	
	public TestClass() {}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestClass [camera=");
		builder.append(camera);
		builder.append("]");
		return builder.toString();
	}
	
	
}
