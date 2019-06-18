package com.serizaliza.demo1;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -4054875461885859849L;
    @Protobuf(fieldType= FieldType.STRING)
    private String name;
    @Protobuf(fieldType= FieldType.INT32)
    private int age;

    private transient String number;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }
}
