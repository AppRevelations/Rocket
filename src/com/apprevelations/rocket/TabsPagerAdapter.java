package com.apprevelations.rocket;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Tab1 fragment 
			return new Offers();
		case 1:
			// Tab2 fragment 
			return new InProgress();
		case 2:
			// Tab3 fragment
			return new Completed();
		}

		return null;
	}
      
	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
