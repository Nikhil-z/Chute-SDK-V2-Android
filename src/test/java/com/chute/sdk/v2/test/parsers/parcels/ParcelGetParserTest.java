package com.chute.sdk.v2.test.parsers.parcels;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.requests.ResponseModel;

public class ParcelGetParserTest extends TestCase {

	public void testParcelGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Parcel Details\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/parcels/619358?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":{\"id\":619358,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/619358\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/619358/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-04-08T11:15:06Z\",\"updated_at\":\"2013-04-08T11:15:24Z\",\"shortcut\":\"2B7Evhdb\"}}";
		ResponseParser<ParcelModel> parser = new ResponseParser<ParcelModel>(
				ParcelModel.class);
		try {
			ResponseModel<ParcelModel> responseModel = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			ParcelModel parcel = responseModel.getData();
			assertEquals(parcel.getId(), "619358");
			assertEquals(parcel.getCreatedAt(), "2013-04-08T11:15:06Z");
			assertEquals(parcel.getUpdatedAt(), "2013-04-08T11:15:24Z");
			assertEquals(parcel.getShortcut(), "2B7Evhdb");
			assertNotNull(parcel.getLinks());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
