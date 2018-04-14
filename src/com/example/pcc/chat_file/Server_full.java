package com.example.pcc.chat_file;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_full {

    public static void main(String[] args) {


        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                { ServerSocket ss= null;
                    ObjectOutputStream oos=null;
                    try {
                        ss = new ServerSocket(8080);
                        System.out.println("Connecting...");
                        while (true) {
                            Socket s = ss.accept();
                            System.out.println("Accept...");
                            oos =new ObjectOutputStream(s.getOutputStream());
                            ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
                            User user_details =(User) din.readObject();
                            int id = user_details.getid();
                            String user = user_details.getuser();
                            String password = user_details.getPassword();
                            String email = user_details.getEmail();
                            System.out.println(id + " " + user + " " + password + " " + email );
                            s.close();
                            /*dout=new DataOutputStream(s.getOutputStream());
                            dout.writeUTF(str);
                            dout.flush();
                            dout.close();*/
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Problem");
                    }
                }
            }
        });
        t.start();
    }

}
