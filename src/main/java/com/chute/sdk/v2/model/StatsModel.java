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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The {@link StatsModel} class holds information regarding number of uploaded
 * and imported assets to a specific source destination made by the user.
 * 
 */
@JsonPropertyOrder({ "user_counts", "source_counts" })
public class StatsModel {

	public static final String TAG = StatsModel.class.getSimpleName();

	/**
	 * Number of uploaded and imported assets by a specific user
	 */
	@JsonProperty("user_counts")
	private UserCountModel userCounts;
	/**
	 * Number of uploaded and imported assets to a specific source destination
	 */
	@JsonProperty("source_counts")
	private SourceCountModel sourceCounts;

	/**
	 * Default non-args constructor
	 */
	public StatsModel() {
	}

	/**
	 * Getters and setters
	 */
	public UserCountModel getUserCounts() {
		return userCounts;
	}

	public void setUserCounts(UserCountModel userCounts) {
		this.userCounts = userCounts;
	}

	public SourceCountModel getSourceCounts() {
		return sourceCounts;
	}

	public void setSourceCounts(SourceCountModel sourceCounts) {
		this.sourceCounts = sourceCounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlbumStatsModel [userCounts=");
		builder.append(userCounts);
		builder.append(", sourceCounts=");
		builder.append(sourceCounts);
		builder.append("]");
		return builder.toString();
	}

}
