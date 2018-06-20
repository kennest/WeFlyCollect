package com.wefly.weflycollectlab.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wefly.weflycollectlab.R;
import com.wefly.weflycollectlab.tasks.LoginTask;

public class LoginActivity extends Activity {

    protected EditText txt_username;
    protected EditText txt_password;
    protected Button btn_login;
    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

        setContentView(R.layout.activity_login);

        txt_username = findViewById(R.id.username);
        txt_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.bt_login);

        //on appel la fonction de login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin(txt_username.getText().toString(), txt_password.getText().toString());
            }
        });

    }

    private void doLogin(String username, String password) {
        LoginTask logintask = new LoginTask(username, password,context);
        logintask.execute();
    }
}
