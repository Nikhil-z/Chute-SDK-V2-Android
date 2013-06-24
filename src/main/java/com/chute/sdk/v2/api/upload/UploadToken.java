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
package com.chute.sdk.v2.api.upload;

import com.chute.sdk.v2.model.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadToken {
	@SuppressWarnings("unused")
	private static final String TAG = UploadToken.class.getSimpleName();

	@JsonProperty("upload_info")
	private UploadInfo uploadInfo;

	@JsonProperty("user")
	private UserModel user;

	@JsonProperty("id")
	private String id; 
	
	@JsonProperty("is_portrait")
	private boolean isPortrait;
	
	@JsonProperty("shortcut")
	private String shortcut;
	
	@JsonProperty("url")
	private String url;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("height")
	private String height;

	@JsonProperty("import_id")
	private String importId;

	@JsonProperty("import_url")
	private String importUrl;

	@JsonProperty("is_published")
	private String isPublished;

	@JsonProperty("location")
	private String location;

	@JsonProperty("md5")
	private String md5;

	@JsonProperty("name")
	private String name;

	@JsonProperty("original_url")
	private String originalUrl;

	@JsonProperty("service")
	private String service;

	@JsonProperty("source")
	private String source;

	@JsonProperty("source_id")
	private String sourceId;

	@JsonProperty("source_url")
	private String sourceUrl;

	@JsonProperty("status")
	private String status;

	@JsonProperty("thumb_url")
	private String thumbUrl;

	@JsonProperty("type")
	private String type;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("username")
	private String username;

	@JsonProperty("width")
	private String width;

	public UploadToken() {
	}

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

	public String getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(String isPublished) {
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
		return "UploadToken [uploadInfo=" + uploadInfo + ", user=" + user
				+ ", id=" + id + ", isPortrait=" + isPortrait + ", shortcut="
				+ shortcut + ", url=" + url + ", createdAt=" + createdAt
				+ ", height=" + height + ", importId=" + importId
				+ ", importUrl=" + importUrl + ", isPublished=" + isPublished
				+ ", location=" + location + ", md5=" + md5 + ", name=" + name
				+ ", originalUrl=" + originalUrl + ", service=" + service
				+ ", source=" + source + ", sourceId=" + sourceId
				+ ", sourceUrl=" + sourceUrl + ", status=" + status
				+ ", thumbUrl=" + thumbUrl + ", type=" + type + ", updatedAt="
				+ updatedAt + ", username=" + username + ", width=" + width
				+ "]";
	}

}
