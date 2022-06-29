package com.apps.todonotepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    RadioGroup themeGroup;
    RadioButton themeChsn;
    Button applyButton,btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        themeGroup = findViewById(R.id.themeRadioGroup);
        themeChsn = findViewById(R.id.rd_default);
        applyButton = findViewById(R.id.btn_themeApply);

        btnAboutUs = findViewById(R.id.btn_about_us);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rbSelected = themeGroup.getCheckedRadioButtonId();
                themeChsn = findViewById(rbSelected);

                if(themeGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(SettingsActivity.this , "Please choose a theme" , Toast.LENGTH_SHORT).show();
                }
                else{
                    if(themeChsn.getText().toString().toUpperCase().equals("LIGHT")){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                    else if(themeChsn.getText().toString().toUpperCase().equals("DARK")){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                    else if(themeChsn.getText().toString().toUpperCase().equals("SYSTEM DEFAULT")){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    }
                }
            }
        });

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAboutUs = new Intent(getApplicationContext(),AboutUsScreenActivity.class);
                startActivity(goToAboutUs);
            }
        });



    }
}