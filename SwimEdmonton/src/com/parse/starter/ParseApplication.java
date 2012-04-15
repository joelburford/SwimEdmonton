package com.parse.starter;

import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	public static String APPLICATION_ID = "DcxvQsrLX2Clw2mKjd2BCwsJsqfSncfnpWmcbuoW";
	public static String CLIENT_KEY = "FvlQkCJCH76gapO53mKVlcwzvl9xafUYokpppPbe";
	
	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);


		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		// Optionally enable public read access by default.
		// defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
