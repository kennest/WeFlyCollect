package com.wefly.weflycollectlab.interfaces;

import org.json.JSONObject;

public interface LoginAsyncResponse {
    //Add requestCode to identify request.
    public void processFinish(String sb);
}
