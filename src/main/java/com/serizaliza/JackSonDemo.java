package com.serizaliza;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.serizaliza.demo1.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static java.lang.String.format;

public class JackSonDemo {
    private static Person init(){
        Person person = new Person();
        person.setNumber("123");
        person.setAge(11);
        person.setName("zhangsan");
        return person;
    }

    public static void main(String[] args) {
        toJackJson();

        toFastJson();

        toProtoBufferJson();
    }


    private static void toJackJson(){
        ObjectMapper writer = new ObjectMapper();
        long l = System.currentTimeMillis();
        System.out.println(format("1开始时间为%s",l));
        byte[] bytes = null;
        for (int i=0;i<100;i++) {
            try {
                bytes = writer.writeValueAsBytes(JackSonDemo.init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(format("1一共消耗时间%s",System.currentTimeMillis() - l));
        try {
            Person person = writer.readValue(bytes, Person.class);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void toFastJson(){
        long l = System.currentTimeMillis();
        System.out.println(format("2开始时间为%s",l));
        byte[] bytes = null;
        for (int i=0;i<100;i++) {
            bytes = JSON.toJSONBytes(JackSonDemo.init());
        }
        System.out.println(format("2一共消耗时间%s",System.currentTimeMillis() - l));

        Person person = JSON.parseObject(bytes,Person.class);
        System.out.println(person);
    }

    private static void toProtoBufferJson(){
        long l = System.currentTimeMillis();
        System.out.println(format("3开始时间为%s",l));
        Codec<Person> objectCodec = ProtobufProxy.create(Person.class, false);
        byte[] bytes = null;
        for (int i=0;i<100;i++) {
            try {
                 bytes = objectCodec.encode(JackSonDemo.init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(format("3一共消耗时间%s",System.currentTimeMillis() - l));

        Person person = null;
        try {
            person = objectCodec.decode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }
}
