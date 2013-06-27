package com.chute.sdk.v2.model;

import java.io.File;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.chute.sdk.v2.utils.MD5;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link LocalAssetModel} class represents a concept of a local asset. Each
 * local asset contains status, file, priority.
 * 
 */
@JsonFilter("localAssetModelFilter")
public class LocalAssetModel implements Parcelable {

	private static final String TAG = LocalAssetModel.class.getSimpleName();

	/**
	 * Enumeration for the status of the local asset. It can be one of the
	 * following types: UNVERIFIED, NEW, INITIALIZED, COMPLETE or SKIP.
	 */
	public enum AssetStatus {
		UNVERIFIED("unverified"), NEW("new"), INITIALIZED("initialized"), COMPLETE(
				"complete"), SKIP("skip");

		/**
		 * Method used for getting the status of the local asset.
		 * 
		 * @param name
		 */
		private AssetStatus(String name) {
			this.name = name;
		}

		/**
		 * Name of the status.
		 */
		private final String name;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return name;
		}

	}

	/**
	 * The unique identifier of the local asset.
	 */
	@JsonProperty("id")
	private String assetId;

	/**
	 * The File type of the local asset.
	 */
	private File file;

	/**
	 * The priority of the local asset.
	 */
	private int priority;

	/**
	 * Status of the local asset.
	 */
	@JsonProperty("status")
	private AssetStatus assetStatus;

	/**
	 * The md5 of the file.
	 */
	@JsonProperty("md5")
	private String fileMD5;

	/**
	 * File type
	 */
	@JsonProperty("type")
	private String identifier;

	/**
	 * Constructor
	 */
	public LocalAssetModel() {
		super();
		this.assetStatus = AssetStatus.UNVERIFIED;
		this.priority = 1;
	}

	/**
	 * Getter and setter methods.
	 */
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File localImageFile) {
		this.file = localImageFile;
	}

	public void setFile(String path) {
		this.file = new File(path);
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public AssetStatus getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(AssetStatus assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getFileMD5() {
		return fileMD5;
	}

	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSize() {
		return String.valueOf(file.length());
	}

	/**
	 * Method used for getting MD5 checksum
	 * 
	 */
	public String calculateFileMD5() {
		try {
			this.fileMD5 = MD5.getMD5Checksum(this.file.getPath());
			return this.fileMD5;
		} catch (Exception e) {
			Log.w(TAG, "", e);
		}
		return "";
	}

	public LocalAssetModel(Parcel in) {
		assetId = in.readString();
		file = (File) in.readSerializable();
		priority = in.readInt();
		assetStatus = AssetStatus.values()[in.readInt()];
		fileMD5 = in.readString();
		identifier = in.readString();
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

	/**
	 * Method used for resolving the asset status.
	 * 
	 * @param assetStatus
	 *            String variable which represents the asset status.
	 * @return {@link AssetStatus#name}.
	 */
	public static AssetStatus resolveAssetStatus(String assetStatus) {
		if (assetStatus.contentEquals(AssetStatus.NEW.toString())) {
			return AssetStatus.NEW;
		} else if (assetStatus
				.contentEquals(AssetStatus.INITIALIZED.toString())) {
			return AssetStatus.INITIALIZED;
		} else if (assetStatus.contentEquals(AssetStatus.COMPLETE.toString())) {
			return AssetStatus.COMPLETE;
		} else if (assetStatus.contentEquals(AssetStatus.SKIP.toString())) {
			return AssetStatus.SKIP;
		}
		return AssetStatus.UNVERIFIED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(assetId);
		dest.writeSerializable(file);
		dest.writeInt(priority);
		dest.writeInt(assetStatus.ordinal());
		dest.writeString(fileMD5);
		dest.writeString(identifier);

	}

	public static final Parcelable.Creator<LocalAssetModel> CREATOR = new Parcelable.Creator<LocalAssetModel>() {

		@Override
		public LocalAssetModel createFromParcel(Parcel in) {
			return new LocalAssetModel(in);
		}

		@Override
		public LocalAssetModel[] newArray(int size) {
			return new LocalAssetModel[size];
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GCLocalAssetModel [assetId=");
		builder.append(assetId);
		builder.append(", file=");
		builder.append(file);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", assetStatus=");
		builder.append(assetStatus);
		builder.append(", fileMD5=");
		builder.append(fileMD5);
		builder.append(", identifier=");
		builder.append(identifier);
		builder.append("]");
		return builder.toString();
	}

}