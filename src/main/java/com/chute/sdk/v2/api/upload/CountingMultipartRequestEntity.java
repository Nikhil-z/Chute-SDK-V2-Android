package com.chute.sdk.v2.api.upload;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class CountingMultipartRequestEntity implements HttpEntity {

  private final HttpEntity delegate;

  private final ProgressListener listener;

  public CountingMultipartRequestEntity(final HttpEntity entity,
      final ProgressListener listener) {
    super();
    this.delegate = entity;
    this.listener = listener;
  }

  public long getContentLength() {
    return this.delegate.getContentLength();
  }

  public Header getContentType() {
    return this.delegate.getContentType();
  }

  public boolean isRepeatable() {
    return this.delegate.isRepeatable();
  }

  public static interface ProgressListener {

    void transferred(long num);
  }

  public static class CountingOutputStream extends FilterOutputStream {

    private final ProgressListener listener;

    private long transferred;

    public CountingOutputStream(final OutputStream out,
        final ProgressListener listener) {
      super(out);
      this.listener = listener;
      this.transferred = 0;
    }

    public void write(byte[] b, int off, int len) throws IOException {
      out.write(b, off, len);
      this.transferred += len;
      this.listener.transferred(this.transferred);
    }

    public void write(int b) throws IOException {
      out.write(b);
      this.transferred++;
      this.listener.transferred(this.transferred);
    }
  }

  @Override
  public void consumeContent() throws IOException {
    this.delegate.consumeContent();
  }

  @Override
  public InputStream getContent() throws IOException, IllegalStateException {
    return this.delegate.getContent();
  }

  @Override
  public Header getContentEncoding() {
    return this.delegate.getContentEncoding();
  }

  @Override
  public boolean isChunked() {

    return this.delegate.isChunked();
  }

  @Override
  public boolean isStreaming() {
    return this.delegate.isStreaming();
  }

  @Override
  public void writeTo(OutputStream out) throws IOException {
    this.delegate.writeTo(new CountingOutputStream(out, this.listener));

  }
}