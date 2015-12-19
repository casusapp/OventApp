package com.ovent.data.entites;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kunal on 18/12/15.
 */
public final class ErrorEntity {

    @SerializedName("message")
    private String mMessage;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
