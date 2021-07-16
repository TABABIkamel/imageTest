package com.image.image.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Lob;
@Document(collection = "image")
public class Image {
    @Id
    String id;
    @Field
    String name;
    @Field
    String location;

    public Image() {

    }

    public Image(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Image(String id, String name, String location) {
        this.id = id;

        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
