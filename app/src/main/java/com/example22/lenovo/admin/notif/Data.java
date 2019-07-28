package com.example22.lenovo.admin.notif;

public class Data {

    String user ;
    String sented ;
    int icon ;
    String body ;
    String title ;
    String key ;

    public Data(String user, String sented, int icon, String body, String title,String key) {
        this.user = user;
        this.sented = sented;
        this.icon = icon;
        this.body = body;
        this.title = title;
        this.key = key ;
    }

    public Data() {
    }
}
