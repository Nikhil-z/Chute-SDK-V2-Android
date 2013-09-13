// Copyright (c) 2011, Chute Corporation. All rights reserved.
// 
//  Redistribution and use in source and binary forms, with or without modification, 
//  are permitted provided that the following conditions are met:
// 
//     * Redistributions of source code must retain the above copyright notice, this 
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
// 
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
//
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