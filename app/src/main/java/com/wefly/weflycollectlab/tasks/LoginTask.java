package com.wefly.weflycollectlab.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.wefly.weflycollectlab.models.Token;
import com.wefly.weflycollectlab.ui.ShowDialog;
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
    protected String username;
    protected String password;
    protected Token token=new Token();

    public LoginTask(String username,String password){
        this.username=username;
        this.password=password;
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
    //params:parametres de connexion au format {username:password}
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

        Log.i("Response Body", response.body().toString());

        if(response.body().toString().contains("token:")){
            this.token.setValeur(response.body().toString().replace("'token:'",""));
            Log.i("Token value Store:",this.token.getValeur());
        }
            return response.body().toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("Finished-Login",s);
    }
}

