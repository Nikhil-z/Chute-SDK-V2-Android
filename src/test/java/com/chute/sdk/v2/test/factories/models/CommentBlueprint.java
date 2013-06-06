package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.CommentModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(CommentModel.class)
public class CommentBlueprint {

	@Default
	String commentText = "This is my comment";
	
	@Default
	String name = "Comment Name";

	@Default
	String email = "olga@getchute.com";
}