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

import com.chute.sdk.v2.utils.JsonUtil;
import com.dg.libs.android.logger.ALog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Comments offer the ability for users to interact and comment on assets inside
 * an album. Each comment holds links, time and date of creation and update,
 * comment text, user name and user e-mail.
 * 
 */
public class CommentModel implements Parcelable {

	public static final String TAG = CommentModel.class.getSimpleName();

	/**
	 * Unique identifier
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * Comment links
	 */
	@JsonProperty("links")
	private LinkModel links;

	@JsonProperty("user")
	private UserModel user;
	/**
	 * Date and time of creation
	 */
	@JsonProperty("created_at")
	private String createdAt;
	/**
	 * Date and time of update
	 */
	@JsonProperty("updated_at")
	private String updatedAt;
	/**
	 * Comment text
	 */
	@JsonProperty("comment_text")
	private String commentText;
	/**
	 * Name of the user posting the comment
	 */
	@JsonProperty("name")
	private String name;
	/**
	 * E-mail of the user posting the comment
	 */
	@JsonProperty("email")
	private String email;

	/**
	 * Default non-args constructor
	 */
	public CommentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters and setters
	 */

	public String getId() {
		return id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkModel getLinks() {
		return links;
	}

	public void setLinks(LinkModel links) {
		this.links = links;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CommentModel(Parcel in) {
		this();
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		createdAt = in.readString();
		updatedAt = in.readString();
		commentText = in.readString();
		name = in.readString();
		email = in.readString();
		user = in.readParcelable(UserModel.class.getClassLoader());
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
		dest.writeParcelable(links, flags);
		dest.writeString(createdAt);
		dest.writeString(updatedAt);
		dest.writeString(commentText);
		dest.writeString(name);
		dest.writeString(email);
		dest.writeParcelable(user, flags);
	}

	public static final Parcelable.Creator<CommentModel> CREATOR = new Parcelable.Creator<CommentModel>() {

		@Override
		public CommentModel createFromParcel(Parcel in) {
			return new CommentModel(in);
		}

		@Override
		public CommentModel[] newArray(int size) {
			return new CommentModel[size];
		}

	};

	public String serializeComment() {
		FilterProvider filters = new SimpleFilterProvider().addFilter(
				"commentModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("comment_text", "name", "email"));
		String result = null;
		try {
			result = JsonUtil.getMapper().writer(filters)
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			ALog.d("", e);
		}
		return result;
	}

	@Override
	public String toString() {
		return "CommentModel [id=" + id + ", links=" + links + ", user=" + user
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", commentText=" + commentText + ", name=" + name
				+ ", email=" + email + "]";
	}

}
