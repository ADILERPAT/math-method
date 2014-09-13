package com.standard.mathmethod.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.standard.mathmethod.common.Constants;
import com.standard.mathmethod.fragment.PhraseFragment;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
	private String[] data;

	public BaseFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new PhraseFragment();
		Bundle bundle = new Bundle();
		fragment.setArguments(bundle);
		bundle.putInt(Constants.POSITION, i);
		return fragment;
	}
	
	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return data[position];
	}
}