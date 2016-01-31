package com.odc.fragmentini.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.odc.fragmentini.R;

public class ChoiceFragment extends Fragment implements OnClickListener{

	ImageButton btnCameroon,btnGhana,btnIvoryCost;

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onActivityCreated(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_choice, container, false);

        btnCameroon = (ImageButton) view.findViewById(R.id.btn_cameroon);
		btnIvoryCost = (ImageButton) view.findViewById(R.id.btn_ivory_cost);
		btnGhana = (ImageButton) view.findViewById(R.id.btn_ghana);


		btnCameroon.setOnClickListener(this);
		btnIvoryCost.setOnClickListener(this);
		btnGhana.setOnClickListener(this);

		getActivity().getActionBar().setIcon(R.drawable.icon);
		getActivity().getActionBar().setTitle(getResources().getString(R.string.app_name));

		return view;
	}

	@Override
	public void onClick(View v) {

		ContentFragment frg = new ContentFragment();
		Bundle args = new Bundle();

		switch (v.getId()) {
		case R.id.btn_cameroon:
			args.putInt("type", 0);
			break;
		case R.id.btn_ivory_cost:
			args.putInt("type",1);
			break;

		case R.id.btn_ghana:
			args.putInt("type", 2);
			break;

		}
		frg.setArguments(args);
		getFragmentManager().beginTransaction().replace(R.id.container, frg).addToBackStack(null).commit();

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId()==R.id.action_about) {
			getFragmentManager().beginTransaction()
			.add(R.id.container, new AboutFragment())
			.commit();

		}
		return super.onOptionsItemSelected(item);
	}




}
