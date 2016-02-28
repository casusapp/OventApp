package com.ovent.domain;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class Success {
    private String mMessage;
    private boolean mSuccess;

    public Success(final String message, final boolean success){
        mMessage = message;
        mSuccess = success;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean success) {
        mSuccess = success;
    }
}
