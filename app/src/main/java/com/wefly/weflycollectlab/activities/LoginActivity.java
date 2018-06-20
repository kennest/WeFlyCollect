package com.wefly.weflycollectlab.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wefly.weflycollectlab.MainActivity;
import com.wefly.weflycollectlab.R;
import com.wefly.weflycollectlab.interfaces.LoginAsyncResponse;
import com.wefly.weflycollectlab.tasks.LoginTask;

public class LoginActivity extends Activity {

    protected EditText txt_username;
    protected EditText txt_password;
    protected Button btn_login;
    protected Context context;
    private String token;

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


    //Fonction de login
    private void doLogin(String username, String password) {
        LoginTask logintask = new LoginTask(username, password, context, new LoginAsyncResponse() {
            @Override
            public void processFinish(String result) {
                Log.d("Response Asynchronous", result);
                token=result;
                if(token.length()>0){
                    Intent main =new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main);
                }
            }
        });
        logintask.execute();
    }
}
