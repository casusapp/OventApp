package com.ovent.data.entites;

import com.google.gson.annotations.SerializedName;

/**
 * Author : Kunal Chavhan
 * Date : 3/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventEntity {

    @SerializedName("name")
    private String mName;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("description")
    private String mDesscription;
    @SerializedName("address")
    private AddressEntity mAddress;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getDesscription() {
        return mDesscription;
    }

    public void setDesscription(String mDesscription) {
        this.mDesscription = mDesscription;
    }

    public AddressEntity getAddress() {
        return mAddress;
    }

    public void setAddress(AddressEntity mAddress) {
        this.mAddress = mAddress;
    }
}
