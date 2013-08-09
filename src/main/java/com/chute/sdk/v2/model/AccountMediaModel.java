package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link AccountMediaModel} class represents the concept of a media item
 * for a specific object that belongs to an account. Each media item contains
 * URL, thumbnail URL and large image URL.
 * 
 */
public class AccountMediaModel implements Parcelable {

	@SuppressWarnings("unused")
	private static final String TAG = AccountMediaModel.class.getSimpleName();

	/**
	 * The unique identifier of the media item.
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * The URL that shows the location of the thumbnail.
	 */
	@JsonProperty("thumb")
	private String thumb;
	/**
	 * The URL that shows the location of the large image.
	 */
	@JsonProperty("large")
	private String large;
	/**
	 * The URl that shows the location of the media item.
	 */
	@JsonProperty("url")
	private String url;

	/**
	 * Photo dimensions
	 */
	@JsonProperty("dimensions")
	private String dimensions;


	/**
	 * Default non-args constructor.
	 */
	public AccountMediaModel() {
		super();
	}

	/**
	 * Getter and setter methods.
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThumbUrl() {
		return thumb;
	}

	public void setThumbUrl(String thumb) {
		this.thumb = thumb;
	}

	public String getLargeUrl() {
		return large;
	}

	public void setLargeUrl(String large) {
		this.large = large;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public AccountMediaModel(Parcel in) {
		id = in.readString();
		thumb = in.readString();
		large = in.readString();
		url = in.readString();
		dimensions = in.readString();
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
		dest.writeString(id);
		dest.writeString(thumb);
		dest.writeString(large);
		dest.writeString(url);
		dest.writeString(dimensions);
	}

	public static final Parcelable.Creator<AccountMediaModel> CREATOR = new Parcelable.Creator<AccountMediaModel>() {

		@Override
		public AccountMediaModel createFromParcel(Parcel in) {
			return new AccountMediaModel(in);
		}

		@Override
		public AccountMediaModel[] newArray(int size) {
			return new AccountMediaModel[size];
		}

	};

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountMediaModel [id=");
		builder.append(id);
		builder.append(", thumb=");
		builder.append(thumb);
		builder.append(", large=");
		builder.append(large);
		builder.append(", url=");
		builder.append(url);
		builder.append(", dimensions=");
		builder.append(dimensions);
		builder.append("]");
		return builder.toString();
	}

}
