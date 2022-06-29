package com.apps.todonotepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tomer.fadingtextview.FadingTextView;

import java.util.Random;

public class SplashScreenActivity extends AppCompatActivity {

    TextView randomTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //        //remove the title bar
        //        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //        //remove action bar
        //        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

        randomTip = findViewById(R.id.random_Tip);
        String Tips [] = {"Never Postbone Todays work" , "Work Till Your Idols become Your Fans" , "Take the Risk or Lose The Chance!" , "Procrastination is The Enemy of success"};
        Random random = new Random();
        int index = random.nextInt(Tips.length);
        randomTip.setText(Tips[index]);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent gotoMainActivity = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(gotoMainActivity);
                finish();
            }
        }).start();
    }
}