package com.ovent.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class implements parcelable of @link{com.ovent.domain.User}
 *
 * @author : Kunal Chavhan
 * @date : 18/12/15 : 12:02 AM
 */

public final class UserModel implements Parcelable {

    private String mPassword;
    private String mPhoneNumber;
    private String mName;
    private String mEmail;
    private String mAddress;
    private String mId;
    private String mSiteId;
    private String mAuthKey;
    public UserModel(){}

    public UserModel(final String phone,final String password){
        mPhoneNumber = phone;
        mPassword = password;
    }

    public UserModel(final String name, final String email,final String address){
        mName = name;
        mEmail = email;
        mAddress =address;
        // mPassword = password;
    }

    protected UserModel(Parcel in){
        mPhoneNumber = in.readString();
        mPassword = in.readString();
        mName = in.readString();
        mEmail = in.readString();
        mAddress = in.readString();
        mId = in.readString();
        mSiteId = in.readString();
        mAuthKey = in.readString();

    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };


    public String getPassword(){
        return mPassword;
    }

    public String getPhoneNumber(){
        return  mPhoneNumber;
    }

    public String getName(){
        return mName;
    }

    public String getEmail(){
        return mEmail;
    }

    public String getAddress(){
        return mAddress;
    }

    public String getId(){
        return  mId;

    }
    public String getSiteId(){
        return mSiteId;
    }


    public void setName(String name){
        mName = name;
    }

    public void setEmail(String email){
        mEmail = email;
    }

    public void setPhoneNumber(String phone){
        mPhoneNumber = phone;
    }

    public void setAddress(String address){
        mAddress = address;
    }


    public void setPassword(String password){
        mPassword = password;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPhoneNumber);
        parcel.writeString(mPassword);
        parcel.writeString(mName);
        parcel.writeString(mEmail);
        parcel.writeString(mAddress);
        parcel.writeString(mId);
        parcel.writeString(mAuthKey);

    }

    public String getAuthKey() {
        return mAuthKey;
    }

    public void setAuthKey(String mAuthKey) {
        this.mAuthKey = mAuthKey;
    }

}