package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AlbumDeleteParserTest extends TestCase {

	public void testAlbumDeleteParser() {

		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> reponse = parser.parse(TestUtil.readResourceAsStream("parser/album/AlbumDelete.json"));
			assertEquals(reponse.getResponse().getTitle(), "Album Deleted");
		} catch (Exception e) {
			fail();
		}
	}

}
