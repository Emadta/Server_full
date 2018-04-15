package com.example.pcc.chat_file;
import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String user ,email ,password;



    public User(String user1 , String email1 , String password1)
    {
        user=user1;
        email=email1;
        password=password1;
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
