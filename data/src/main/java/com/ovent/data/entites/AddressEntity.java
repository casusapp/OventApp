package com.ovent.data.entites;

import com.google.gson.annotations.SerializedName;

/**
 * Author : Kunal Chavhan
 * Date : 3/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class AddressEntity {
    @SerializedName("lat")
    private String mLat;
    @SerializedName("long")
    private String mLong;

public AddressEntity(){}
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
