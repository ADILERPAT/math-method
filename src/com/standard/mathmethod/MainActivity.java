package com.standard.mathmethod;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.standard.englishconversation.R;
import com.standard.mathmethod.adapter.BaseFragmentPagerAdapter;
import com.standard.mathmethod.common.Constants;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private BaseFragmentPagerAdapter ApplicationFragmentPagerAdapter;
	private BaseFragmentPagerAdapter secondFragmentPagerAdapter;
	private BaseFragmentPagerAdapter conversationFragmentPagerAdapter;
	private BaseFragmentPagerAdapter irregularFragmentPagerAdapter;
	private BaseFragmentPagerAdapter tensFragmentPagerAdapter;
	private ViewPager mViewPager;
	private ActionBar actionBar;
	private ListView mDrawerList;
	private String[] listArray;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
		
		// Create array tab
		String wordCommon[] = getResources().getStringArray(R.array.word_common);
		String wordToeic[] = getResources().getStringArray(R.array.word_toeic);
		String conversation[] = getResources().getStringArray(R.array.conversation);
		String irregularVebs[] = getResources().getStringArray(R.array.irregular_vebs);
		String tens[] = getResources().getStringArray(R.array.tens);
		
		// Create the adapter that will return a fragment for each tab
		ApplicationFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
		ApplicationFragmentPagerAdapter.setData(wordCommon);
		
		secondFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
		secondFragmentPagerAdapter.setData(wordToeic);
		
		conversationFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
		conversationFragmentPagerAdapter.setData(conversation);
		
		irregularFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
		irregularFragmentPagerAdapter.setData(irregularVebs);
		
		tensFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
		tensFragmentPagerAdapter.setData(tens);
		
		// Set up the action bar.
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Set up the ViewPager
		mViewPager = (ViewPager) findViewById(R.id.pager);
		loadTabAndPage(ApplicationFragmentPagerAdapter,"");

		// Add List Left Menu
		listArray = getResources().getStringArray(R.array.planets_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, listArray));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setLogo(R.drawable.transparent);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {};

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}
	
	private void loadTabAndPage(FragmentPagerAdapter fragmentPagerAdapter, String title){
		actionBar.setTitle(title);
		mViewPager.setAdapter(fragmentPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// add a tab to the action bar.
		actionBar.removeAllTabs();
		for (int i = 0; i < fragmentPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab().setText(fragmentPagerAdapter.getPageTitle(i)).setTabListener(this)); 
		}
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(tab.getPosition());
		
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return false;
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			selectItem(position); 
		}
	}

	private void selectItem(int position) {
		Constants.POSITION_ITEM_LIST = position;
		switch (position) {
		case 0:
			loadTabAndPage(ApplicationFragmentPagerAdapter,listArray[0]);
			break;
		case 1:
			loadTabAndPage(secondFragmentPagerAdapter,listArray[1]);
			break;
		case 2:
			loadTabAndPage(conversationFragmentPagerAdapter,listArray[2]);
			break;
		case 3:
			loadTabAndPage(irregularFragmentPagerAdapter,listArray[3]);
			break;
		default:
			loadTabAndPage(tensFragmentPagerAdapter,listArray[4]);
			break;
		}
		mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
}

