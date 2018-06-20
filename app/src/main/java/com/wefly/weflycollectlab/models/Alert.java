package com.wefly.weflycollectlab.models;

import java.util.Date;
import java.util.List;

public class Alert {
    private String titre;
    private String contenu;
    private double longitude;
    private double latitude;
    private Date date_alert;

    private List<Integer> recipients;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getDate_alert() {
        return date_alert;
    }

    public void setDate_alert(Date date_alert) {
        this.date_alert = date_alert;
    }

    public List<Integer> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Integer> recipients) {
        this.recipients = recipients;
    }
}
