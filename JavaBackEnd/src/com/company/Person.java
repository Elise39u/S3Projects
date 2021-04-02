package com.company;
/*
   https://happycoding.io/tutorials/java-server/rest-api
   example used to create this test api
 */
public class Person {
    private String Name;
    private String About;
    private int Age;

    public Person(String name, String about, int age) {
        this.Name = name;
        this.About = about;
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public  String getAbout() {
        return About;
    }

    public int getAge() {
        return Age;
    }
}
