package com.wefly.weflycollectlab.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.wefly.weflycollectlab.MainActivity;
import com.wefly.weflycollectlab.R;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splashThread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        splashThread.start();
    }
}
