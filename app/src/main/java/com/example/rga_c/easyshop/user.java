package com.example.rga_c.easyshop;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {
    private static int count=0;
    private int id;
    private String username;
    private String email;
    private String password;

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(password);
    }

    public user(Parcel in){
        this.id = in.readInt();
        this.username = in.readString();
        this.email = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<user> CREATOR = new Parcelable.Creator<user>() {
        public user createFromParcel(Parcel in){
            return new user(in);
        }

        public user[] newArray(int size){
            return new user[size];
        }
    };


    public user(String username, String email, String password) {
        this.id = ++count;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}