package com.example.kymanage.Beans.General;

public class Token {
    private boolean scanOver;

    public Token() {
    }

    public Token(boolean scanOver) {
        this.scanOver = scanOver;
    }

    public boolean isScanOver() {
        return scanOver;
    }

    public void setScanOver(boolean scanOver) {
        this.scanOver = scanOver;
    }
}
