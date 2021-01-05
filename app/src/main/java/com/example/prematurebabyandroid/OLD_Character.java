package com.example.prematurebabyandroid;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OLD_Character implements Parcelable {
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

    public OLD_Character(){}

    protected OLD_Character(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<OLD_Character> CREATOR = new Creator<OLD_Character>() {
        @Override
        public OLD_Character createFromParcel(Parcel in) {
            return new OLD_Character(in);
        }

        @Override
        public OLD_Character[] newArray(int size) {
            return new OLD_Character[size];
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
