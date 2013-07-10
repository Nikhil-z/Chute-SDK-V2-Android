package com.chute.sdk.v2.api.upload;

import java.io.InputStream;

import org.apache.http.entity.mime.content.InputStreamBody;

public class InputStreamKnownSizeBody extends InputStreamBody {

	private int length;

	@SuppressWarnings("deprecation")
	public InputStreamKnownSizeBody(final InputStream in, final int length, final String mimeType, final String fileName) {
		super(in, mimeType, fileName);
		this.length = length;
	}

	@Override
	public long getContentLength() {
		return this.length;
	}

}
