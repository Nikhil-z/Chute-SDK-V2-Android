package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.AssetModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(AssetModel.class)
public class AssetBlueprint {

	@Default
	String caption = "sunset";

	@Default
	int votes = 0;

	@Default
	int hearts = 0;
}