package com.odc.actionbar;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TabsActivity extends Activity implements TabListener {
	
	List<Fragment> fragList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

	    super.onCreate(savedInstanceState);  
	    ActionBar bar = getActionBar();
	    
	    TestFragement f1 = new TestFragement();
	    TestFragement f2 = new TestFragement();
	    TestFragement f3 = new TestFragement();
	    fragList = new ArrayList<Fragment>();
	    fragList.add(f1);
	    fragList.add(f2);
	    fragList.add(f3);

	    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	    for (int i=1; i <= 3; i++) {

	        Tab tab = bar.newTab();

	        tab.setText("Tab " + i);

	        tab.setTabListener(this);

	        bar.addTab(tab);
	    }
	}

	@Override
	    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	        Fragment f = null;

	        TestFragement tf = null;

	 
	        if (fragList.size() > tab.getPosition())
	                fragList.get(tab.getPosition());

	        if (f == null) {
	            tf = new TestFragement();
	            Bundle data = new Bundle();

	            data.putInt("idx",  tab.getPosition());
	            tf.setArguments(data);
	            fragList.add(tf);

	        }
	        else

	            tf = (TestFragement) f;
	        ft.replace(android.R.id.content, tf);

	 
	    }

	    @Override

	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	        if (fragList.size() > tab.getPosition()) {

	            ft.remove(fragList.get(tab.getPosition()));

	        }

	    }

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}


}