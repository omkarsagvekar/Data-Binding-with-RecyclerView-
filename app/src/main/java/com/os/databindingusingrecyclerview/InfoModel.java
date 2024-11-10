package com.os.databindingusingrecyclerview;

public class InfoModel {
    String name, sirName, age;

    public InfoModel(String name, String sirName, String age) {
        this.name = name;
        this.sirName = sirName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSirName() {
        return sirName;
    }

    public String getAge() {
        return age;
    }
}
