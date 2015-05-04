package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.AlbumModel;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

@Blueprint(AlbumModel.class)
public class AlbumBlueprint {

    @Default
    String name = "car make";
    
    @Default
    String id = "423dsf";
}