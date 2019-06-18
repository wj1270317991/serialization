package com.serizaliza.demo1;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) {

        serializationPerson();
        UnSerializationPerson();
    }




    //序列化
    private static void serializationPerson(){
        ObjectOutputStream person = null;
        try {
            person = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person p = new Person();
            p.setName("张三李四");
            p.setNumber("1024");
            p.setAge(12);
            person.writeObject(p);
            person.flush();
            person.writeObject(p);
            person.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                person.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //反序列化
    private static void UnSerializationPerson(){
        try {
            ObjectInputStream person = new ObjectInputStream(new FileInputStream(new File("person")));
            Person o = (Person)person.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
