// Copyright (c) 2011, Chute Corporation. All rights reserved.
// 
//  Redistribution and use in source and binary forms, with or without modification, 
//  are permitted provided that the following conditions are met:
// 
//     * Redistributions of source code must retain the above copyright notice, this 
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
// 
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
// 
package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class containing {@link AssetModel} and {@link UploadInfo} properties.
 * 
 */
public class UploadToken {
	@SuppressWarnings("unused")
	private static final String TAG = UploadToken.class.getSimpleName();

	/**
	 * Upload information
	 */
	@JsonProperty("upload_info")
	private UploadInfo uploadInfo;

	/**
	 * User uploading the asset
	 */
	@JsonProperty("user")
	private UserModel user;

	/**
	 * Asset ID
	 */
	@JsonProperty("id")
	private String id;

	/**
	 * Flag indicating whether the file is in portrait
	 */
	@JsonProperty("is_portrait")
	private boolean isPortrait;

	/**
	 * Asset shortcut
	 */
	@JsonProperty("shortcut")
	private String shortcut;

	/**
	 * Asset URL
	 */
	@JsonProperty("url")
	private String url;

	/**
	 * Time and date of creation
	 */
	@JsonProperty("created_at")
	private String createdAt;

	/**
	 * Height of the asset
	 */
	@JsonProperty("height")
	private String height;

	/**
	 * Import ID
	 */
	@JsonProperty("import_id")
	private String importId;

	/**
	 * Import URL
	 */
	@JsonProperty("import_url")
	private String importUrl;

	/**
	 * Flag indicating whether the asset is published
	 */
	@JsonProperty("is_published")
	private boolean isPublished;

	/**
	 * Asset location
	 */
	@JsonProperty("location")
	private String location;

	/**
	 * Asset MD5 checksum
	 */
	@JsonProperty("md5")
	private String md5;

	/**
	 * Asset name
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * URL the asset originated from
	 */
	@JsonProperty("original_url")
	private String originalUrl;

	/**
	 * Asset service
	 */
	@JsonProperty("service")
	private String service;

	/**
	 * The source the asset is uploaded to
	 */
	@JsonProperty("source")
	private String source;

	/**
	 * Source ID
	 */
	@JsonProperty("source_id")
	private String sourceId;

	/**
	 * Source URL
	 */
	@JsonProperty("source_url")
	private String sourceUrl;

	/**
	 * Asset status. It can be one of the following types: unverified, new,
	 * initialized, complete or skip.
	 */
	@JsonProperty("status")
	private String status;

	/**
	 * Thumbnail URL
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;

	/**
	 * Type of the uploaded file: image or video
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Time and date of updating the asset
	 */
	@JsonProperty("updated_at")
	private String updatedAt;

	/**
	 * Username of the user who uploaded the asset
	 */
	@JsonProperty("username")
	private String username;

	/**
	 * Asset width
	 */
	@JsonProperty("width")
	private String width;

	/**
	 * Getters and setters
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getImportId() {
		return importId;
	}

	public void setImportId(String importId) {
		this.importId = importId;
	}

	public String getImportUrl() {
		return importUrl;
	}

	public void setImportUrl(String importUrl) {
		this.importUrl = importUrl;
	}

	public boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public UploadInfo getUploadInfo() {
		return uploadInfo;
	}

	public void setUploadInfo(UploadInfo uploadInfo) {
		this.uploadInfo = uploadInfo;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPortrait() {
		return isPortrait;
	}

	public void setPortrait(boolean isPortrait) {
		this.isPortrait = isPortrait;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadToken [uploadInfo=");
		builder.append(uploadInfo);
		builder.append(", user=");
		builder.append(user);
		builder.append(", id=");
		builder.append(id);
		builder.append(", isPortrait=");
		builder.append(isPortrait);
		builder.append(", shortcut=");
		builder.append(shortcut);
		builder.append(", url=");
		builder.append(url);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", height=");
		builder.append(height);
		builder.append(", importId=");
		builder.append(importId);
		builder.append(", importUrl=");
		builder.append(importUrl);
		builder.append(", isPublished=");
		builder.append(isPublished);
		builder.append(", location=");
		builder.append(location);
		builder.append(", md5=");
		builder.append(md5);
		builder.append(", name=");
		builder.append(name);
		builder.append(", originalUrl=");
		builder.append(originalUrl);
		builder.append(", service=");
		builder.append(service);
		builder.append(", source=");
		builder.append(source);
		builder.append(", sourceId=");
		builder.append(sourceId);
		builder.append(", sourceUrl=");
		builder.append(sourceUrl);
		builder.append(", status=");
		builder.append(status);
		builder.append(", thumbUrl=");
		builder.append(thumbUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", username=");
		builder.append(username);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}

}
