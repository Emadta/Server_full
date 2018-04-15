package com.example.pcc.chat_file;

import javax.jws.soap.SOAPBinding;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Savefile {
ObjectOutputStream oos_file;
FileOutputStream fos;
    List<User> list;
    User user_details;
    Savefile (User user_details1){
        user_details=user_details1;
    }

    public void do_save_file() {
            try {
                fos = new FileOutputStream("user.txt");
                oos_file=new ObjectOutputStream(fos);
                list=new ArrayList<>();
                list.add(user_details);
                oos_file.writeObject(list);
                oos_file.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (oos_file !=null)
                {
                    try {
                        oos_file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

}
