package com.example.prematurebabyandroid;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Character implements Parcelable {
    @SerializedName("id")
    private int id;
//    public int id;

    @SerializedName("name")
    private String name;
//    public String name;

//    public Character(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Character(){}

    protected Character(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
