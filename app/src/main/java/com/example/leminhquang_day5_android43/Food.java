package com.example.leminhquang_day5_android43;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    String name;
    int price;
    int number;

    public Food(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    protected Food(Parcel in) {
        name = in.readString();
        price = in.readInt();
        number = in.readInt();
    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeInt(getPrice());
        parcel.writeInt(getNumber());
    }
}
