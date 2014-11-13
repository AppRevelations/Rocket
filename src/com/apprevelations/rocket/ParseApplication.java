package com.apprevelations.rocket;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, 
				"vue6wjAz1048XntKQHbfxNN7uKsX0Z2BfpmjkWlB", 
				"g3KdhdOnbhXQkVcNPBXFDiM0tkgoR5oBaCkIoga3");

		
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
