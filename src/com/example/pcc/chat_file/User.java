package com.example.pcc.chat_file;
import java.io.Serializable;


public class User implements Serializable {
    private int id;
    private String user ,email ,password;



    public User(int id1 , String user1 , String email1 , String password1)
    {
        id=id1;
        user=user1;
        email=email1;
        password=password1;
    }

    public int getid() {
        return id ;
    }

    public void setid(int num) {
        id = num;
    }

    public String getuser() {
        return user ;
    }

    public void setuser(String name) {
        user = name;
    }

    public String getPassword() {
        return password ;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public String getEmail() {
        return email ;
    }

    public void setEmail(String em) {
        email = em;
    }



}
