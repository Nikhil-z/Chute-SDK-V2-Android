package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * The {@link ProfileModel} class holds information regarding the user profile.
 */
public class ProfileModel implements Parcelable {

	/**
	 * First name of the user
	 */
	@JsonProperty("first_name")
	private String firstName;
	/**
	 * Last name of the user
	 */
	@JsonProperty("last_name")
	private String lastName;
	/**
	 * User e-mail
	 */
	@JsonProperty("email")
	private String email;
	/**
	 * User phone number
	 */
	@JsonProperty("phone_number")
	private String phoneNumber;
	/**
	 * User birth year
	 */
	@JsonProperty("birth_year")
	private String birthYear;

	/**
	 * Getter and setter methods
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public ProfileModel() {
	}

	public ProfileModel(Parcel in) {
		this();
		firstName = in.readString();
		lastName = in.readString();
		email = in.readString();
		phoneNumber = in.readString();
		birthYear = in.readString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeString(email);
		dest.writeString(phoneNumber);
		dest.writeString(birthYear);
	}

	public static final Parcelable.Creator<ProfileModel> CREATOR = new Parcelable.Creator<ProfileModel>() {

		@Override
		public ProfileModel createFromParcel(Parcel in) {
			return new ProfileModel(in);
		}

		@Override
		public ProfileModel[] newArray(int size) {
			return new ProfileModel[size];
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfileModel [firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", birthYear=" + birthYear + "]";
	}

}
