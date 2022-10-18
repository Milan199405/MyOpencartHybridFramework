package com.qa.opencart.utils;

import java.util.ArrayList;

public class Constants {
	public static final String LOGIN_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";

	public static final int DEFAULT_TIMEOUT = 5;

	public static final String LOGIN_PAGE_ERROR_MSG = "Warning: No match for E-Mail Address and/or Password.";
	public static final String ACCOUNT_CREATION_SUCCESS_MSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "Registration";
	
	public static ArrayList<String> accountPageContents() {
		ArrayList<String> contents = new ArrayList<String>();
		contents.add("My Account");
		contents.add("My Orders");
		contents.add("My Affiliate Account");
		contents.add("Newsletter");
		
		return contents;
	}
}
