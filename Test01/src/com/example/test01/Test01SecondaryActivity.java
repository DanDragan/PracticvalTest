package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Test01SecondaryActivity extends Activity {
	
	private class ButtonClickListener implements Button.OnClickListener {
		 
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button01:
	          setResult(RESULT_OK, new Intent());
	          finish();
	          break;
	        case R.id.button02:
	          setResult(RESULT_CANCELED, new Intent());
	          finish();
	          break;
	      }
	    }
	  }  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test01_secondary);
		
		EditText etext = (EditText) findViewById(R.id.editText01);
		Button verify = (Button) findViewById(R.id.button01);
		Button cancel = (Button) findViewById(R.id.button02);
		
		Intent intent = getIntent();
	    if (intent != null) {
	      String numberOfClicks = intent.getStringExtra("number_of_clicks");
	      if (numberOfClicks != null) {
	        etext.setText(numberOfClicks);
	      } else {
	    	  etext.setText("");
	      }
	    }
		
		ButtonClickListener listener = new ButtonClickListener();
		verify.setOnClickListener(listener);
		cancel.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test01_secondary, menu);
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
}
