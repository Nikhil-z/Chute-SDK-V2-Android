package com.chute.sdk.v2.test.parsers.parcels;

import java.awt.List;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ListResponseModel;

public class ParcelAlbumGetParserTest extends TestCase {

	public void testParcelAlbumGetParser() {

		String jsonResponse = "{\"response\":{\"title\":\"Parcel Listing\",\"version\":2,\"code\":200,\"href\":\"https://api.getchute.com/v2/albums/2399241/parcels?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\"},\"data\":[{\"id\":619358,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/619358\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/619358/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-04-08T11:15:06Z\",\"updated_at\":\"2013-04-08T11:15:24Z\",\"shortcut\":\"2B7Evhdb\"},{\"id\":619355,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/619355\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/619355/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-04-08T10:30:15Z\",\"updated_at\":\"2013-04-08T10:30:16Z\",\"shortcut\":\"2B7Bqcnv\"},{\"id\":615650,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/615650\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/615650/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-04-02T16:32:35Z\",\"updated_at\":\"2013-04-02T16:33:04Z\",\"shortcut\":\"2A9Qkvwi\"},{\"id\":610031,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/610031\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/610031/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-04-01T13:48:02Z\",\"updated_at\":\"2013-04-01T13:48:03Z\",\"shortcut\":\"2yHdnkac\"},{\"id\":600476,\"links\":{\"self\":{\"href\":\"http://api.getchute.com/v2/parcels/600476\",\"title\":\"Parcel Details\"},\"assets\":{\"href\":\"http://api.getchute.com/v2/parcels/600476/assets\",\"title\":\"Asset Listing\"}},\"created_at\":\"2013-03-26T22:28:32Z\",\"updated_at\":\"2013-03-26T22:28:43Z\",\"shortcut\":\"2wd6pqyu\"}],\"pagination\":{\"current_page\":1,\"next_page\":\"https://api.getchute.com/v2/albums/2399241/parcels?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e&page=2\",\"previous_page\":null,\"first_page\":\"https://api.getchute.com/v2/albums/2399241/parcels?bearer_token=f7f1a31c46f95f4085956ae146aa0f3eec1874a9d17ec07de5e22d7c7340da0e\",\"per_page\":5}}";
		ListResponseParser<ParcelModel> parser = new ListResponseParser<ParcelModel>(
				ParcelModel.class);
		try {
			ListResponseModel<ParcelModel> parcels = parser.parse(IOUtils
					.toInputStream(jsonResponse));
			ParcelModel parcel = parcels.getData().get(0);
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
