package com.example.samplesmsreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 電話の受信を受け取るにはphonestatelistenerを使う。brではない。READ_PHONE_STATEのパーミッション記述
		PhoneStateListener mListener = new PhoneStateListener() {
			public void onCallStateChanged(int state, String number) {

				switch (state) {

				case TelephonyManager.CALL_STATE_RINGING: // かかってきた状態
					Log.i("かかってきた", number);
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK: // かかってきてとった状態
					Log.i("とった", number);
					break;

				case TelephonyManager.CALL_STATE_IDLE: // 切った状態
					Log.i("きった", number);
					break;

				}
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
