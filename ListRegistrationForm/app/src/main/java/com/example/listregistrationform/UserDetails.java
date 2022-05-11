package com.example.listregistrationform;

import java.io.Serializable;

public class UserDetails implements Serializable {
    String userName;
    String city;
    String mob;
    String password;
    int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public  UserDetails(String userName, String password, String city, String mob,int icon){
        this.userName = userName;
        this.city = city;
        this.mob = mob;
        this.password = password;
        this.icon=icon;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
