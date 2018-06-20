package com.wefly.weflycollectlab.utils;

public class Constants {
    // APP NAME
    public static final String APP_NAME         = "WeFlyCollect";
    public static final String PATH             = "WeFlyCollect";

    // BASE
    //public static final String BASE_URL = "http://192.168.1.66:8000/";
    public static final String BASE_URL = "http://217.182.133.143:8000/";

    // GET
    public static final String LOGIN_URL = BASE_URL + "login/";

    //POST
    public static final String SEND_SMS_URL         = BASE_URL + "communications/api/sms/";

    //GET
    public static final String RECIPIENTS_URL            = BASE_URL + "communications/api/liste-employes/";
    //GET
    public static final String SMS_RECEIVE_URL           = BASE_URL + "sms-recu-mobile/?recu=";
    //GET
    public static final String SMS_SENT_URL              = BASE_URL + "sms/";

    public static final String EMAIL_RECEIVE_URL         = BASE_URL + "communications/api/email-receive-status/";

    public static final String EMAIL_SENT_URL            = BASE_URL + "communications/api/email-display/";

    public static final String ALERT_RECEIVE_URL         = BASE_URL + "communications/api/alerte-receive-status/";

}
