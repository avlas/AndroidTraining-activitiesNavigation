package com.formation.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);

		ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
		logo.setImageResource(R.drawable.nature);

		Button backButton = (Button) findViewById(R.id.button_back);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mainActivity = new Intent(FormActivity.this, MainActivity.class);
				startActivity(mainActivity);
			}
		});
	}

	public void onRadioButtonClicked(View view) {
		RadioGroup sexRadioGroup = (RadioGroup) findViewById(R.id.radioGroup_sex);
		int selectedIdRadioBtn = sexRadioGroup.getCheckedRadioButtonId();
		RadioButton sexRadioBtn = (RadioButton) findViewById(selectedIdRadioBtn);
	}
	
	protected void onPause() {
		super.onPause();
		setContentView(R.layout.activity_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.form, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
