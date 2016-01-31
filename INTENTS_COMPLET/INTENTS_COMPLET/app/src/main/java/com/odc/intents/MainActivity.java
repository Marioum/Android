package com.odc.intents;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.odc.intents.R;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.les_intents);
	}

	@SuppressWarnings("deprecation")
	public void callIntent(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.Button01:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.google.com"));
			startActivity(intent);
			break;
		case R.id.Button02:
			intent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel:(+216)99123456"));
            startActivity(intent);
			break;
		case R.id.Button03:
			intent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:99123456"));
			startActivity(intent);
			break;
		case R.id.Button04:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:36.899202,10.189615?z=19"));
			startActivity(intent);
			break;
		case R.id.Button05:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:0,0?q=SidiBouzid"));
			startActivity(intent);
			break;
		case R.id.Button06:
			intent = new Intent("android.media.action.IMAGE_CAPTURE");
			startActivity(intent);
			break;
		case R.id.Button07:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("content://contacts/people/"));
			startActivity(intent);
			break;
		case R.id.Button08:
			intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
			startActivity(intent);
			break;
		case R.id.Button09:
			intent = new Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			File file = new File("/sdcard/awicha1.mp3");
			intent.setDataAndType(Uri.fromFile(file), "audio/*");
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	public boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(
				intent, PackageManager.MATCH_DEFAULT_ONLY);
		if (resolveInfo.size() > 0) {
			return true;
		}
		return false;
	}
}
