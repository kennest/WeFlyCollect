package com.wefly.weflycollectlab.models;

public class Token {
    private Integer id;
    private String valeur;

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        System.out.println("token value:" +valeur);
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
