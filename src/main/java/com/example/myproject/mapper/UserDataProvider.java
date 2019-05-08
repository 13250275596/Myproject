package com.example.myproject.mapper;

public class UserDataProvider {

    public String getAllUsers(){
        String str = "select * from user";
        return str;
    }
}
