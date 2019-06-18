package com.serizaliza.clone;

import java.io.*;

public class Student implements Serializable {

    private static final long serialVersionUID = -577957491829349406L;

    private String name;

    private int age;

    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Object deepClone(){
        ObjectInputStream objectInputStream = null;
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream ob = new ObjectOutputStream(bytes);
            ob.writeObject(this);
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
