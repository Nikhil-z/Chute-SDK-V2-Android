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
package com.chute.sdk.v2.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.chute.sdk.v2.api.authentication.AuthenticationFactory.AccountType;

public class PreferenceUtil {

	public static final String TAG = PreferenceUtil.class.getSimpleName();
	private static final String BITMAP_PATH = "bitmap_path";
	private static final String ACCOUNT_TOKEN = "account_token";
	private final Context context;

	private PreferenceUtil(Context context) {
		this.context = context;
	}

	static PreferenceUtil instance;

	public static PreferenceUtil get() {
		return instance;
	}

	public static void init(Context context) {
		if (instance == null) {
			instance = new PreferenceUtil(context.getApplicationContext());
		}
	}

	public SharedPreferences getPreferences() {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

	private final <T> void setPreference(final String key, final T value) {
		SharedPreferences.Editor edit = getPreferences().edit();
		if (value.getClass().equals(String.class)) {
			edit.putString(key, (String) value);
		} else if (value.getClass().equals(Boolean.class)) {
			edit.putBoolean(key, (Boolean) value);
		} else if (value.getClass().equals(Integer.class)) {
			edit.putInt(key, (Integer) value);
		} else if (value.getClass().equals(Long.class)) {
			edit.putLong(key, (Long) value);
		} else if (value.getClass().equals(Float.class)) {
			edit.putFloat(key, (Float) value);
		} else {
			throw new UnsupportedOperationException("Need to add a primitive type to shared prefs");
		}
		edit.commit();
	}

	// Account ID
	public void setIdForAccount(AccountType accountType, String accountId) {
		setPreference(accountType.getName(), accountId);
	}

	public boolean hasAccountId(AccountType accountType) {
		return getPreferences().contains(accountType.getName());
	}

	public String getAccountId(AccountType accountType) {
		return getPreferences().getString(accountType.getName(), null);
	}

	// Account Name
	public void setNameForAccount(AccountType accountType, String accountName) {
		setPreference(accountType.getName() + "_name", accountName);
	}

	public boolean hasAccountName(AccountType accountType) {
		return getPreferences().contains(accountType.getName() + "_name");
	}

	public String getAccountName(AccountType accountType) {
		return getPreferences().getString(accountType.getName() + "_name", null);
	}

	// Account UID
	public void setUidForAccount(AccountType accountType, String uid) {
		setPreference(accountType.getName() + "_uid", uid);
	}

	public boolean hasUid(AccountType accountType) {
		return getPreferences().contains(accountType.getName() + "_uid");
	}

	public String getUidForAccount(AccountType accountType) {
		return getPreferences().getString(accountType.getName() + "_uid", null);
	}

	// Bitmap path
	public String getBitmapPath() {
		return getPreferences().getString(BITMAP_PATH, null);
	}

	public void setBitmapPath(String path) {
		setPreference(BITMAP_PATH, path);
	}

	// Account token
	public String getAccountToken() {
		return getPreferences().getString(ACCOUNT_TOKEN, null);
	}

	public void setAccountToken(String token) {
		setPreference(ACCOUNT_TOKEN, token);
	}

}
