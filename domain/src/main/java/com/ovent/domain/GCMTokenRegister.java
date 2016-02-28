package com.ovent.domain;

/**
 * Author : Kunal Chavhan
 * Date : 4/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class GCMTokenRegister {
    private String mDeviceId;
    private String mGCMToken;

    public GCMTokenRegister(){

    }

    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String mDeviceId) {
        this.mDeviceId = mDeviceId;
    }

    public String getGCMToken() {
        return mGCMToken;
    }

    public void setGCMToken(String mGCMToken) {
        this.mGCMToken = mGCMToken;
    }
}
