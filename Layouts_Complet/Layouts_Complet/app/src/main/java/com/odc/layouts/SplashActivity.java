package com.odc.layouts;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.odc.layouts.R;

public class SplashActivity extends Activity {
	ImageView imageLoad,head,body,leftHand,rightHand,leftLeg,RightLeg,logo;
	
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);

		imageLoad = (ImageView)findViewById(R.id.logo_android);
		imageLoad.setVisibility(View.VISIBLE);
		AnimationDrawable frameAnimation = (AnimationDrawable)imageLoad.getDrawable();
		frameAnimation.setCallback(imageLoad);
		frameAnimation.setVisible(true, true);
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#ffffff")));
		getActionBar().setIcon(imageLoad.getDrawable());
		
		logo = (ImageView) findViewById(R.id.sim);
		head = (ImageView) findViewById(R.id.head);
		body = (ImageView) findViewById(R.id.body);
		leftHand = (ImageView) findViewById(R.id.left_hand);
		rightHand = (ImageView) findViewById(R.id.right_hand);
		leftLeg = (ImageView) findViewById(R.id.left_leg);
		RightLeg = (ImageView) findViewById(R.id.right_leg);
		startAnim();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
          public void run() {
        	Intent i = new Intent(SplashActivity.this,MainActivity.class);
  	        startActivity(i);
           finish(); 
          }
        }, 2000);
		
	}
	
	private void startAnim() {
		animate(head, R.anim.bounce);
		animate(leftHand, R.anim.bounce);
		animate(rightHand, R.anim.bounce);
		animate(body, R.anim.zoom_in);
		animate(leftLeg, R.anim.bounce);
		animate(RightLeg, R.anim.bounce);
		animate(logo, R.anim.top_in);
	}
	
	
	
	private void animate(ImageView img , int id) {
		Animation a = AnimationUtils.loadAnimation(this, id);
		a.reset();
		img.clearAnimation();
		img.startAnimation(a);
	}

	public void passe(View v) {
		startAnim();
	}
}
