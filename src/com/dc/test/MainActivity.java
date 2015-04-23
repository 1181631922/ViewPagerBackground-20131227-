package com.dc.test;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.Menu;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

	private GuideViewPager viewPager ;
	private List<Fragment> fragments ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	
	private void initViews(){
		viewPager = (GuideViewPager) findViewById(R.id.guideviewpager);
		viewPager.setBackGroud(BitmapFactory.decodeResource(getResources(), R.drawable.guide_bg));
		fragments = new ArrayList<Fragment>();
		FragmentOne one = new FragmentOne();
		FragmentTwo two = new FragmentTwo();
		FragmentThree three = new FragmentThree();
		FragmentFour four = new FragmentFour();
		FragmentFive five = new FragmentFive();
		fragments.add(one);
		fragments.add(two);
		fragments.add(three);
		fragments.add(four);
		fragments.add(five);
		GuideViewPagerAdapter adapter = new GuideViewPagerAdapter(getSupportFragmentManager(), fragments);
		viewPager.setAdapter(adapter);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class GuideViewPagerAdapter extends FragmentPagerAdapter{

		private List<Fragment> list ;
		
		public GuideViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list ;
		}
		
		@Override
	    public int getItemPosition(Object object) {
	        return super.getItemPosition(object);
	    }

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}
		
	}
	
}
