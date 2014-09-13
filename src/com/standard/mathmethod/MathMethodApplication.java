package com.standard.mathmethod;

import android.app.Application;

import com.standard.mathmethod.adapter.DatabaseAdapter;

public class MathMethodApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
	//	new DatabaseAdapter(this);
	}
}
