package com.company.reflection;

public class Person {

    private String name;
    private Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void myCustomMethod(Integer a, String b, Person p) {}
    public void myCustomMethod(Person p) {}
    public void myCustomMethod(Integer a, Person p) {}
    public void myCustomMethod(String b, Person p) {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
