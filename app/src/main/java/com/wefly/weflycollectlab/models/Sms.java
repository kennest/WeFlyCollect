package com.wefly.weflycollectlab.models;

import java.util.List;

public class Sms {
    private String contenu;
    private List<Integer> recipients;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<Integer> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Integer> recipients) {
        this.recipients = recipients;
    }
}
