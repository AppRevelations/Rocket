package com.apprevelations.rocket;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SignUpChoice extends FragmentActivity {

	private static final String TAG = "SignUpChoice";

	Button Signupemail, signInWithFacebookButton;
	TextView tlogin;

	private UiLifecycleHelper uiHelper;

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {
		if (state.isOpened()) {
			// Log.i(TAG, "Logged in...");
			Intent mainViewIntent = new Intent(SignUpChoice.this,
					com.apprevelations.rocket.MainView.class);
			startActivity(mainViewIntent);
			finish();
		} else if (state.isClosed()) {
			// Log.i(TAG, "Logged out...");
		}
	}

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signupchoice);

		LoginButton authButton = (LoginButton) findViewById(R.id.bwithfb);
		// authButton.setReadPermissions(Arrays
		// .asList("user_likes", "user_status"));

		Signupemail = (Button) findViewById(R.id.bwithemail);
		tlogin = (TextView) findViewById(R.id.tlogin);

		Signupemail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SignUpChoice.this,
						com.apprevelations.rocket.SignUp.class);
				startActivity(i);
			}
		});

		tlogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SignUpChoice.this,
						com.apprevelations.rocket.Login.class);
				startActivity(i);
			}
		});

		uiHelper = new UiLifecycleHelper(SignUpChoice.this, callback);
		uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();

		Session session = Session.getActiveSession();
		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}

		uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}
}
