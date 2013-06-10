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
package com.chute.sdk.v2.api.parsers;

import java.io.InputStream;

import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.parsers.BaseJacksonMapperResponseParser;

public class ResponseParser<T> extends
		BaseJacksonMapperResponseParser<ResponseModel<T>> {

	public static final String TAG = ResponseParser.class.getSimpleName();
	private final Class<?> cls;

	public ResponseParser(Class<?> cls) {
		this.cls = cls;
	}

	@Override
	public ResponseModel<T> parse(InputStream responseBody) throws Exception {
		// JSONObject obj = new JSONObject(responseBody);
		// String res = "{\"Camera\": \"Nokia N95\"}";
		// JSONObject data = new JSONObject(res);
		// obj.put("data", data);
		// Log.d("debug", "obj = " + obj.toString());

		// String res =
		// "{\"latitude\": \"-36.88155833\", \"longitude\": \"174.70791111\"}";

		return mapper.readValue(responseBody, mapper.getTypeFactory()
				.constructParametricType(ResponseModel.class, cls));
	}
}