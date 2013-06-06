package com.chute.sdk.v2.test.factories;

import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;

public class FactoryManager {

	
	private static ModelFactory modelFactory = new ModelFactory();
	static {
		try {
			modelFactory.setRegisterBlueprintsByPackage( "com.chute.sdk.v2.test.factories.models" );
		} catch (RegisterBlueprintException e) {
		}
	}
	
	public static ModelFactory getModelFactory() {
		return modelFactory;
	}
}
