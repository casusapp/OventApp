package com.ovent.presentation.utils;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

/**
 * Created by Kunal on 18/12/15.
 */
public final class Intents {

    private static final String INTENT_PREFIX = "ovent://android";

    private static final Uri CONNECT = Uri.parse(INTENT_PREFIX + "/connect/");
    private static final Uri SOCIAL_LOGIN = Uri.parse(INTENT_PREFIX + "/social_login/");
    private static final Uri HOME = Uri.parse(INTENT_PREFIX + "/home/");
    private static final Uri SIGN_UP = Uri.parse(INTENT_PREFIX + "/sign_up/");
    private static final Uri LOGIN = Uri.parse(INTENT_PREFIX + "/login/");
    private static final Uri FORGOT_PASSWORD = Uri.parse(INTENT_PREFIX + "/forgot_password/");
    private static final Uri SEARCH_LOCATION = Uri.parse(INTENT_PREFIX + "/search_location/");
    private static final Uri BOOKING = Uri.parse(INTENT_PREFIX + "/booking/");
    private static final Uri ACCEPT_DOC = Uri.parse(INTENT_PREFIX + "/accept_doc/");

    public static Intent getConnectIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(CONNECT);
    }

    public static Intent getSocialIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(SOCIAL_LOGIN);
    }

    public static Intent getHomeIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(HOME);
    }

    public static Intent getSignUpIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(SIGN_UP);
    }

    public static Intent getLoginIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(LOGIN);
    }

    public static Intent getForgotPasswordIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(FORGOT_PASSWORD);
    }

    public static Intent getSettingsIntent(){
        return new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    }

    public static Intent getLocationSearchIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(SEARCH_LOCATION);
    }

    public static Intent getBookingIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(BOOKING);
    }

    public static Intent getAcceptDocIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(ACCEPT_DOC);
    }
}