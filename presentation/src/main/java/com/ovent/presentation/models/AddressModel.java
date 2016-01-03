package com.ovent.presentation.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Kunal Chavhan
 * Date : 3/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class AddressModel implements Parcelable{
   private String mLat;
    private String mLong;

    protected AddressModel(Parcel in) {
        mLat = in.readString();
        mLong = in.readString();

    }


    public static final Creator<AddressModel> CREATOR = new Creator<AddressModel>() {
        @Override
        public AddressModel createFromParcel(Parcel in) {
            return new AddressModel(in);
        }

        @Override
        public AddressModel[] newArray(int size) {
            return new AddressModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mLat);
        parcel.writeString(mLong);
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String mLat) {
        this.mLat = mLat;
    }

    public String getLong() {
        return mLong;
    }

    public void setLong(String mLong) {
        this.mLong = mLong;
    }
}
