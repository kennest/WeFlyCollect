package com.wefly.weflycollectlab.models;

import java.io.File;

public class Piece {
    private File piece;
    private Integer email;
    private Integer alert;

    public File getPiece() {
        return piece;
    }

    public void setPiece(File piece) {
        this.piece = piece;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }
}
