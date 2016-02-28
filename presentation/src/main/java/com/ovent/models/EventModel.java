package com.ovent.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.DateTime;

/**
 * Author : Kunal Chavhan
 * Date : 3/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventModel implements Parcelable{

    private String mName;
    private String mTitle;
    private String mDescription;
    private String mCategory;
    private AddressModel mAddress;
    private String mBannerUrl;
    private Boolean mType;
    private DateTime mStartTime;
    private DateTime mEndTime;
    private Boolean mIsFree;

    public EventModel(){

    }
    protected EventModel(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        mCategory = in.readString();
        mTitle = in.readString();
    }


    public static final Creator<EventModel> CREATOR = new Creator<EventModel>() {
        @Override
        public EventModel createFromParcel(Parcel in) {
            return new EventModel(in);
        }

        @Override
        public EventModel[] newArray(int size) {
            return new EventModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mDescription);
        parcel.writeString(mCategory);
        parcel.writeString(mTitle);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public AddressModel getAddress() {
        return mAddress;
    }

    public void setAddress(AddressModel mAddress) {
        this.mAddress = mAddress;
    }

    public void setTitle(String title){this.mTitle = title;}

    public String getTitle(){return this.mTitle;}

    public DateTime getStartTime() {
        return mStartTime;
    }

    public void setStartTime(DateTime mStartTime) {
        this.mStartTime = mStartTime;
    }

    public DateTime getEndTime() {
        return mEndTime;
    }

    public void setEndTime(DateTime mEndTime) {
        this.mEndTime = mEndTime;
    }
}
