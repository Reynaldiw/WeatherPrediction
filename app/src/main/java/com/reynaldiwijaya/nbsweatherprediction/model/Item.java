package com.reynaldiwijaya.nbsweatherprediction.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String city;
    private int image;

    public Item(String city, int image) {
        this.city = city;
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.city);
        dest.writeInt(this.image);
    }

    protected Item(Parcel in) {
        this.city = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
