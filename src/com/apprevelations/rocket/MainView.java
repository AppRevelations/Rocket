package com.apprevelations.rocket;


import com.apprevelations.widget.AppRevelationsModifiedProfilePictureView;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainView extends ActionBarActivity implements OnClickListener {

	AppRevelationsModifiedProfilePictureView profilePictureView;

	Button Bverify;
	Button fill;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.dynamic_feed);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#5c6bc0")));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

		fill=(Button) findViewById(R.id.bfill);
		fill.setOnClickListener(this);
		profilePictureView = (AppRevelationsModifiedProfilePictureView) findViewById(R.id.profile_pic);

		if (Session.getActiveSession().isOpened()) {
			Request.newMeRequest(Session.getActiveSession(),
					new Request.GraphUserCallback() {

						@Override
						public void onCompleted(GraphUser user,
								Response response) {
							// TODO Auto-generated method stub
							profilePictureView.setProfileId(user.getId());
						}
					}).executeAsync();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.overflow:

			return true;
		case R.id.leaderboard:

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bfill:
			Intent i= new Intent(MainView.this, com.apprevelations.rocket.Fill.class);
			startActivity(i);
			break;

		default:
			break;
		}
	}

}