package com.odc.actionbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragement extends Fragment{
	int index;
	public void onCreate(Bundle savedInstanceState) {       
		super.onCreate(savedInstanceState);

		Bundle data = getArguments();

		index = data.getInt("idx");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,

			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_example, null);
		TextView tv = (TextView) v.findViewById(R.id.msg);
		tv.setText("Fragment " + (index + 1));
		return v;

	}

}
