package com.serizaliza.demo2;

import com.serizaliza.demo2.parent.SuperUser;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) {

        serialization();

        deSerialization();
    }


    private static void serialization(){
        ObjectOutputStream user = null;
        try {
            user = new ObjectOutputStream(new FileOutputStream(new File("user")));
            SuperUser u = new User();
            u.setAge(10);
            user.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                user.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void deSerialization(){
        try {
            ObjectInputStream user = new ObjectInputStream(new FileInputStream(new File("user")));
            User o = (User)user.readObject();
            System.out.println(o);

            user.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
