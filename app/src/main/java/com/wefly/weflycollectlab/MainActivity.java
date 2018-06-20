package com.wefly.weflycollectlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.wefly.weflycollectlab.activities.BaseActivity;
import com.wefly.weflycollectlab.activities.LoginActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.checkToken();

        Intent intent=new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);
    }
}
