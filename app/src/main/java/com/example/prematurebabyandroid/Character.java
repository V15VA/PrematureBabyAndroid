package com.example.prematurebabyandroid;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private int id;
//    public int id;

    @SerializedName("name")
    private String name;
//    public String name;

    public Character(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
