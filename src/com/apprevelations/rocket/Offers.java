package com.apprevelations.rocket;


import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;



public class Offers extends Fragment{

	
	LinearLayout main;
	String s_title,s_desc,s_packagename;
	int d_amount;
	static int a=0;
	TextView title, desc, amount;
	Button getmoney;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.offers, container, false);

		main= (LinearLayout) rootView.findViewById(R.id.offerlayout);
		
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Offers");
		query.orderByDescending("amount");
		query.findInBackground(new FindCallback<ParseObject>() {
		   
			@Override
			public void done(List<ParseObject> offersList, ParseException e) {
		        if (e == null) {
		            Log.d("offers", "Retrieved " + offersList.size() + " offers");
		            for (ParseObject offers : offersList) {
		                // This does not require a network access.
		          
		            		
		            		s_packagename= offers.getString("PackageName");
		            	createdynamic(a++,s_packagename);
		            	
		                s_title=offers.getString("title");
		                Log.d("offers title", s_title);
		                s_desc=offers.getString("desc");
		                Log.d("offers desc", s_desc);
		                d_amount=offers.getInt("amount");
		                Log.d("offers amount", String.valueOf(d_amount));
		                title.setText(s_title);
		                desc.setText(s_desc);
		                amount.setText("Install and get Rs" + String.valueOf(d_amount));
		                getmoney.setText("Install and get Rs" + String.valueOf(d_amount));
		            	}
		             
		            
		            
		        } else {
		            Log.d("offers", "Error: " + e.getMessage());
		        }
		    }
		});

		
		
		return rootView;
	}
	
	
	private void createdynamic(int a, final String packagename)
	{

		LayoutInflater inflater = LayoutInflater.from(getActivity());
		LinearLayout profileView = (LinearLayout) inflater.inflate(
				R.layout.single_view, null, false);
		
		main.addView(profileView);
		
		title= (TextView) profileView.findViewById(R.id.tvtitle);
		desc= (TextView) profileView.findViewById(R.id.tvdesc);
		amount= (TextView) profileView.findViewById(R.id.tvmoney);
		getmoney= (Button) profileView.findViewById(R.id.binstall);
		
		getmoney.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				
				getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("market://details?id=" + packagename)));
			}
		});
		
		
	}
}
