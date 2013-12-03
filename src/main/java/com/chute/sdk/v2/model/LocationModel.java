package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationModel implements Parcelable {

	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	
	public LocationModel() {}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocationModel [latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(latitude);
		dest.writeString(longitude);
	}
	
	public LocationModel(Parcel in) {
		latitude = in.readString();
		longitude = in.readString();
	}
	
	public static final Parcelable.Creator<LocationModel> CREATOR = new Parcelable.Creator<LocationModel>() {

	    @Override
	    public LocationModel createFromParcel(Parcel in) {
	      return new LocationModel(in);
	    }

	    @Override
	    public LocationModel[] newArray(int size) {
	      return new LocationModel[size];
	    }

	  };

}
