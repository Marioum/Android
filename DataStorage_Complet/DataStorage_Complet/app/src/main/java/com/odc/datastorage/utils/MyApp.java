package com.odc.datastorage.utils;

import android.app.Application;

public class MyApp extends Application{
	
	private boolean connected = false;
	
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
