package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.SourceModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(SourceModel.class)
public class SourceBlueprint {

	@Default
	String source = "chute";

	@Default
	String sourceId = "123bg";

	@Default
	String sourceUrl = "http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg";

	@Default
	String service = "uploaded";

	@Default
	String importId = "3213asd";

	@Default
	String importUrl = "http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg";
}