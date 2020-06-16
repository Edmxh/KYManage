package com.example.kymanage.Beans;

import java.util.ArrayList;
import java.util.List;

public class LoginBean {

    /**
     * 登录返回值 Bean
     */

    private boolean login;
    private List<String> Authority;
    private ArrayList<String> Authority1;
    private ArrayList<String> Authority2;
    private ArrayList<String> Authority3;
    private ArrayList<String> Authority4;
    private String namedes;

    public String getNamedes() {
        return namedes;
    }

    public void setNamedes(String namedes) {
        this.namedes = namedes;
    }

    public List<String> getAuthority() {
        return Authority;
    }

    public void setAuthority(List<String> authority) {
        Authority = authority;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public ArrayList<String> getAuthority1() {
        return Authority1;
    }

    public void setAuthority1(ArrayList<String> authority1) {
        Authority1 = authority1;
    }

    public ArrayList<String> getAuthority2() {
        return Authority2;
    }

    public void setAuthority2(ArrayList<String> authority2) {
        Authority2 = authority2;
    }

    public ArrayList<String> getAuthority3() {
        return Authority3;
    }

    public void setAuthority3(ArrayList<String> authority3) {
        Authority3 = authority3;
    }

    public ArrayList<String> getAuthority4() {
        return Authority4;
    }

    public void setAuthority4(ArrayList<String> authority4) {
        Authority4 = authority4;
    }

    public boolean getRes() {
        return login;
    }

    public void setRes(boolean login) {
        this.login = login;
    }

    public LoginBean(boolean login) {
        this.login = login;
    }
}
