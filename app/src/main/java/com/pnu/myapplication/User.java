package com.pnu.myapplication;

public class User {
    String _name;
    String _password;
    public User(){   }
    public User( String name, String password){
        this._name = name;
        this._password = password;
    }
    public String getName(){
        return this._name;
    }
    public void setName(String name){
        this._name = name;
    }

    public String getPassword(){
        return this._password;
    }

    public void setPassword(String password){
        this._password = password;
    }
}
