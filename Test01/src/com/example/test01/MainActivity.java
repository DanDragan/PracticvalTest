package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static int tleftclick;
	private static int trightclick;
	private static int centerclick;
	private static int bleftclick;
	private static int brightclick;

	private class BtnClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {

			switch (view.getId()) {
			case R.id.button6:
				Intent intent = new Intent("com.example.test01.intent.action.Test01SecondaryActivity");
				intent.putExtra("number_of_clicks",  String.valueOf(centerclick));
				startActivityForResult(intent, 1);
				break;
			}
		}
	}

	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			EditText editText = (EditText) findViewById(R.id.editText1);

			Button but = (Button) view;
			String text = editText.getText().toString();

			switch (view.getId()) {
			case R.id.button1:
				tleftclick++;
				editText.setText(text + "," + but.getText().toString());
				break;
			case R.id.button2:
				trightclick++;
				editText.setText(text + "," + but.getText().toString());
				break;
			case R.id.button3:
				centerclick++;
				editText.setText(text + "," + but.getText().toString());
				break;
			case R.id.button4:
				bleftclick++;
				editText.setText(text + "," + but.getText().toString());
				break;
			case R.id.button5:
				brightclick++;
				editText.setText(text + "," + but.getText().toString());
				break;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState != null) {
			tleftclick = savedInstanceState.getInt("tleftclick");
			trightclick = savedInstanceState.getInt("trightclick");
			centerclick = savedInstanceState.getInt("center_click");
			bleftclick = savedInstanceState.getInt("bleftclick");
			bleftclick = savedInstanceState.getInt("bleftclick");

			Toast.makeText(this, "Nr clicks center " + centerclick,
					Toast.LENGTH_LONG).show();
		} else {
			tleftclick = 0;
			trightclick = 0;
			centerclick = 0;
			bleftclick = 0;
			bleftclick = 0;
		}

		Button tleft = (Button) findViewById(R.id.button1);
		Button tright = (Button) findViewById(R.id.button2);
		Button center = (Button) findViewById(R.id.button3);
		Button bleft = (Button) findViewById(R.id.button4);
		Button bright = (Button) findViewById(R.id.button5);
		Button navigate = (Button) findViewById(R.id.button6);
		EditText editText = (EditText) findViewById(R.id.editText1);
		editText.setEnabled(false);

		ButtonClickListener listener = new ButtonClickListener();
		BtnClickListener listener2 = new BtnClickListener();
		tleft.setOnClickListener(listener);
		tright.setOnClickListener(listener);
		center.setOnClickListener(listener);
		bleft.setOnClickListener(listener);
		bright.setOnClickListener(listener);
		navigate.setOnClickListener(listener2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt("tleftclick", tleftclick);
		savedInstanceState.putInt("trightclick", trightclick);
		savedInstanceState.putInt("center_click", centerclick);
		savedInstanceState.putInt("brightclick", brightclick);
		savedInstanceState.putInt("brightclick", brightclick);
		Toast.makeText(this, "Nr clicks center " + centerclick,
				Toast.LENGTH_LONG).show();
	}
}
