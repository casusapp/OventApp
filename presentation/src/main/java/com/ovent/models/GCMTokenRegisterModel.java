package com.ovent.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Kunal Chavhan
 * Date : 4/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class GCMTokenRegisterModel implements Parcelable{
    private String mDeviceId;
    private String mGCMToken;

    protected GCMTokenRegisterModel(Parcel in) {
        mDeviceId = in.readString();
        mGCMToken = in.readString();
    }

    public static final Creator<GCMTokenRegisterModel> CREATOR = new Creator<GCMTokenRegisterModel>() {
        @Override
        public GCMTokenRegisterModel createFromParcel(Parcel in) {
            return new GCMTokenRegisterModel(in);
        }

        @Override
        public GCMTokenRegisterModel[] newArray(int size) {
            return new GCMTokenRegisterModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(mDeviceId);
            parcel.writeString(mGCMToken);
    }
}
