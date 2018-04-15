package com.example.pcc.chat_file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server_full {

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                {   Boolean result;
                    ServerSocket ss= null;
                    ObjectOutputStream oos=null;
                    ObjectOutputStream oos_file=null;
                    Socket s=null;
                    try {
                        ss = new ServerSocket(8080);
                        System.out.println("Connecting...");
                        while (true) {
                            s = ss.accept();
                            System.out.println("Accept...");
                            oos =new ObjectOutputStream(s.getOutputStream());
                            ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
                            User user_details =(User) din.readObject();
                            String user = user_details.getuser();
                            String password = user_details.getPassword();
                            String email = user_details.getEmail();
                            System.out.println(" " + user + " " + password + " " + email );
                            Loadfile loadfile=new Loadfile();
                            result=loadfile.do_load_file(user_details);
                            if (result) {
                                Savefile savefile = new Savefile(user_details);
                                savefile.do_save_file();
                                oos.writeBoolean(result);
                            }
                            else
                            {
                                oos.writeBoolean(result);
                            }
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
                    finally {
                        if (s !=null)
                        {
                            try {
                                s.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        });
        t.start();
    }

}
