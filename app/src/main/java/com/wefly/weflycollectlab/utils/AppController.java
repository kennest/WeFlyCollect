package com.wefly.weflycollectlab.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.wefly.weflycollectlab.MainActivity;
import com.wefly.weflycollectlab.activities.LoginActivity;
import com.wefly.weflycollectlab.helpers.DBManager;

public class AppController extends Application{
    private static Context appContext ;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        /* If you has other classes that need context object to initialize when application is created,
         you can use the appContext here to process. */
        checkToken();
    }

    //Verifie Si le token est en stocker en sqlite
    protected void checkToken(){
        DBManager dao = new DBManager(appContext);
        dao= dao.open();
        Cursor c = dao.selectionner();
        if (c.getCount()>0) {
            System.out.println("Base activity token:"+c.getString(0));
            Intent main =new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(main);
        } else
            System.out.println("No token Found");
        Intent main =new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);;
        startActivity(main);
    }

    public static Context getAppContext() {
        return appContext;
    }
}
