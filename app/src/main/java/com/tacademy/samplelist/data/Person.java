package com.tacademy.samplelist.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class Person {
    private String name;
    private int age;
    private Drawable photo;//사진의 데이터 타입은 Drawable

    public Person() {
    }

    public Person(String name, int age, Drawable photo) {
        this.name = name;
        this.age = age;
        this.photo = photo;
    }

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

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }
}
