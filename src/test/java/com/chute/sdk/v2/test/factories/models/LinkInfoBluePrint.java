package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.LinkInfoModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(LinkInfoModel.class)
public class LinkInfoBluePrint {
	
	@Default
	String href = "http://api.getchute.com/v2/assets/364003199";
	
	@Default
	String title = "Asset Details";

}
