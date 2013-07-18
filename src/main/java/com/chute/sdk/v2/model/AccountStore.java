
	private AuthConstants authConstants;

	private Bundle buildAccount(final Context context, String username, String password) {
		Bundle result = null;
		AccountManager am = AccountManager.get(context);
		if (Constants.DEBUG) {
			Log.e(TAG, AuthConstants.ACCOUNT_TYPE);
		}
		Account[] chuteAccounts = am.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
		if (chuteAccounts.length > 0) {
			if (Constants.DEBUG) {
				Log.e("ACCOUNTS", String.valueOf(chuteAccounts.length));
			}
			for (Account ac : chuteAccounts) {
				if (!username.contentEquals(ac.name)) {
					am.removeAccount(ac, null, null);
					Account account = new Account(username, AuthConstants.ACCOUNT_TYPE);
					if (am.addAccountExplicitly(account, password, null)) {
						result = new Bundle();
						result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
						result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
						return result;
					} else {
						return null;
					}
				} else if (!am.getPassword(ac).contentEquals(password)) {
					am.setPassword(ac, password);
				}
			}
		} else {
			Account account = new Account(username, AuthConstants.ACCOUNT_TYPE);
			if (am.addAccountExplicitly(account, password, null)) {
				result = new Bundle();
				result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
				result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
				return result;
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Usage:
	 * 
	 * <pre>
	 * Bundle b = addAccount(uInfo.getEmail(), uInfo.getApiKey());
	 * if (b != null) {
	 * 	setAccountAuthenticatorResult(b);
	 * }
	 * </pre>
	 * 
	 * Use it with an extended AccountAuthenticatorActivity to provide a way to
	 * add an account via the accounts and sync screen. Using account requires
	 * manifest permissions:
	 * 
	 * <pre>
	 *  uses-permission android:name="android.permission.GET_ACCOUNTS"
	 *  uses-permission android:name="android.permission.MANAGE_ACCOUNTS"
	 *  uses-permission android:name="android.permission.AUTHENTICATE_ACCOUNTS"
	 * </pre>
	 * 
	 * @param context
	 * @param username
	 *            The account username
	 * @param password
	 *            the app token used to access the api's
	 * @return an Authentication Bundle
	 */
	public Bundle addAccount(Activity activity, String username, String password) {
		final Bundle bundle = buildAccount(activity, username, password);
		if (bundle != null) {
			this.setUsername(username);
			this.setPassword(password);
		}
		return bundle;
	}

	private void getAccountInfo(Context context) {

		AccountManager am = AccountManager.get(context);
		Account[] chuteAccounts = am.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
		if (chuteAccounts.length > 0) {
			this.setUsername(chuteAccounts[0].name);
			this.setPassword(am.getPassword(chuteAccounts[0]));
			return;
		}
		// IF there is no account added, get the token from shared preferences
		String apiKey = restoreApiKey(context);
		if (!TextUtils.isEmpty(apiKey)) {
			this.setUsername("ChuteDefaultUsername");
			this.setPassword(apiKey);
			return;
		}
		// Set a manual token for testing
		// this.setUsername("ChuteDefaultUsername");
		// this.setPassword("46e580a90085912ed11c565084f1f2465f28630bd58fa80cc98432f3078fc5ac");
	}

	/**
	 * Use as an alternative for saving the token to accounts (Note that using
	 * the account manager is a preferred and safer method)
	 * 
	 * @param apiKey
	 *            the token acquired from chute auth
	 * @param context
	 * @return if the save was successful
	 */
	public boolean saveApiKey(String apiKey, Context context) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putString(API_KEY, apiKey);
		boolean commit = editor.commit();
		getAccountInfo(context);
		return commit;
	}

	public boolean isTokenValid() {
		return !TextUtils.isEmpty(password);
	}

	public boolean clearAuth() {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.remove(API_KEY);
		boolean commit = editor.commit();
		AccountManager am = AccountManager.get(context);
		Account[] chuteAccounts = am.getAccountsByType(AuthConstants.ACCOUNT_TYPE);
		for (Account ac : chuteAccounts) {
			am.removeAccount(ac, null, null);
		}
		return commit;
	}

	public String restoreApiKey(Context context) {
		SharedPreferences savedSession = PreferenceManager.getDefaultSharedPreferences(context);
		return savedSession.getString(API_KEY, "");
	}

	public boolean saveDeviceId(String deviceId, Context context) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putString(DEVICE_ID, deviceId);
		return editor.commit();
	}

	public String restoreDeviceId(Context context) {
		SharedPreferences savedSession = PreferenceManager.getDefaultSharedPreferences(context);
		return savedSession.getString(DEVICE_ID, "");
	}

	public boolean saveUserId(String userId, Context context) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putString(USER_ID, userId);
		return editor.commit();
	}

	public String restoreUserId(Context context) {
		SharedPreferences savedSession = PreferenceManager.getDefaultSharedPreferences(context);
		return savedSession.getString(USER_ID, "");
	}

	private static boolean saveAppId(Context context, String appId) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putString(KEY_APP_ID, appId);
		return editor.commit();
	}

	private static String restoreAppId(Context context) {
		SharedPreferences savedSession = PreferenceManager.getDefaultSharedPreferences(context);
		return savedSession.getString(KEY_APP_ID, null);
	}

	/**
	 * <p>
	 * Use {@link #AUTHENTICATION_REQUEST_CODE} inside the onActivityResult to
	 * check the request code
	 * <p>
	 * Use {@link Activity#RESULT_OK} for the result code if the auth was
	 * successful
	 * 
	 * <pre>
	 * <b> For errors use the following constants for the result code </b>
	 * Use {@link GCAuthenticationActivity#CODE_HTTP_EXCEPTION}} - For connection problems
	 * Use {@link GCAuthenticationActivity#CODE_HTTP_ERROR}} - For server issues, see logcat for detailed error
	 * Use {@link GCAuthenticationActivity#CODE_PARSER_EXCEPTION}} - For result parsing errors, see logcat for details
	 * </pre>
	 * 
	 * @param activity
	 * @param accountType
	 * @param scope
	 * @param redirectUri
	 * @param clientId
	 * @param clientSecret
	 */
	public void startAuthenticationActivity(Activity activity, AccountType accountType, String scope,
			String redirectUri, String clientId, String clientSecret) {
		Intent intent = new Intent(activity, AuthenticationActivity.class);
		authConstants = new AuthConstants(accountType, scope, redirectUri, clientId, clientSecret);
		activity.startActivityForResult(intent, AUTHENTICATION_REQUEST_CODE);
	}

	public AuthConstants getAuthConstants() {
		return authConstants;
	}

	public static class AuthConstants {

		/**
		 * Account type string.
		 */
		public static String ACCOUNT_TYPE;

		public static final String PARAM_PASSWORD = "password";
		public static final String PARAM_USERNAME = "username";

		public AccountType accountType;
		public String scope;
		public String redirectUri;
		public String clientId;
		public String clientSecret;

		public AuthConstants(AccountType accountType, String scope, String redirectUri, String clientId,
				String clientSecret) {
			super();
			this.accountType = accountType;
			this.scope = scope;
			this.redirectUri = redirectUri;
			this.clientId = clientId;
			this.clientSecret = clientSecret;
		}

	}

	@Override
	public void authenticateRequest(BaseRestClient client) {
		client.addHeader("Authorization", "Bearer " + getPassword());

	}

}