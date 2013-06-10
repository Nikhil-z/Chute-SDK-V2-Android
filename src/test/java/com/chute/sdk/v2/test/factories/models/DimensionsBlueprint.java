package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.DimensionsModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(DimensionsModel.class)
public class DimensionsBlueprint {

	@Default
	String width = "75";

	@Default
	String height = "75";
}