package com.example.test2.c;

/**
 * @author :yinxiaolong
 * @describe : com.example.test2.c
 * @date :2023/4/15 21:19
 */
public class User {

    private int id;
    private String name;
    private int age;
    private String email;

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return id + "," + name + "," + age + "," + email;
    }

    public static User fromString(String data) {
        String[] parts = data.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int age = Integer.parseInt(parts[2]);
        String email = parts[3];
        return new User(id, name, age, email);
    }
}

