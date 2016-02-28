package com.ovent.data.entites;

import com.google.gson.annotations.SerializedName;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class SuccessEntity {
    @SerializedName("success")
    private boolean mSuccess;
    @SerializedName("message")
    private String mMessage;

    public SuccessEntity(){}
    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
