package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.LinkInfoModel;
import com.chute.sdk.v2.model.LinkModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Mapped;

@Blueprint(LinkModel.class)
public class LinksBluePrint {

	@Mapped
	LinkInfoModel self;

}
