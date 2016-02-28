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
    @SerializedName("title")
    private String mTitle;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("desc")
    private String mDesscription;
    @SerializedName("venue")
    private AddressEntity mAddress;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("end_time")
    private String mEndTime;

    public EventEntity(){}

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

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String mStartTime) {
        this.mStartTime = mStartTime;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String mEndTime) {
        this.mEndTime = mEndTime;
    }
}
