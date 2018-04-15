package com.example.pcc.chat_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loadfile {
    ObjectInputStream ois;
    FileInputStream fis;
    List<User> list;
    Boolean result=true;
    public Boolean do_load_file(User user_email) {
        try {
            fis = new FileInputStream("user.txt");
            ois=new ObjectInputStream(fis);
            list=(List<User>) ois.readObject();
            for ( User user_detail :list)
            {
                if (user_detail.getEmail().equals(user_email.getEmail()))
                {
                    result=false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois !=null)
            {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
