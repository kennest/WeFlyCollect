package com.wefly.weflycollectlab.tasks;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.wefly.weflycollectlab.activities.LoginActivity;
import com.wefly.weflycollectlab.helpers.DBManager;
import com.wefly.weflycollectlab.models.Token;
import com.wefly.weflycollectlab.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


//Tache de connexion
public class LoginTask extends AsyncTask<String, Integer, String> {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();
    private String url = Constants.LOGIN_URL;
    protected Context context;
    protected String username;
    protected String password;
    protected DBManager dao;
    protected String result;

    public LoginTask(String username, String password, Context ctx) {
        this.username = username;
        this.password = password;
        this.context = ctx;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            login(url);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return "Login Process Finished!";
    }


    //Fonction de connexion
    //url:l'URL de connexion
    private String login(String url) throws IOException, JSONException {
        JSONObject json = new JSONObject();
        json.put("username", username.trim());
        json.put("password", password.trim());

        Log.i("JSON BODY", json.toString());

        RequestBody body = RequestBody.create(JSON, json.toString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        result = response.body().string();
        Log.i("Response Body", result);

        //Si les credentials sont correct,donc StatusCode=200
        if (response.code() == 200) {
            dao = new DBManager(context);
            dao.open();

            //On creer un objet json avec le
            JSONObject jo = new JSONObject(result);

            //On Supprime les enregistrements
            dao.deleteAll();

            //on ajoute le nouveau token
            dao.ajouter(jo.getString("token"));

            Cursor c = dao.selectionner();
            System.out.println("token count:"+c.getCount());
            if (c.moveToFirst()) {
                System.out.println("Token 1:"+c.getString(0));
            } else
                System.out.println("No token Found");
        }
        Log.i("Response Body 2", result);
        return response.body().toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("Finished-Login", s);
    }
}

