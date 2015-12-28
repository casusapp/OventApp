package com.ovent.presentation.utils;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

/**
 * Created by Kunal on 18/12/15.
 */
public final class Intents {

    private static final String INTENT_PREFIX = "ovent://android";
    private static final Uri HOME = Uri.parse(INTENT_PREFIX + "/home/");
    private static final Uri SIGN_UP = Uri.parse(INTENT_PREFIX + "/sign_up/");
    private static final Uri LOGIN = Uri.parse(INTENT_PREFIX + "/login/");

    public static Intent getHomeIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(HOME);
    }

    public static Intent getSignUpIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(SIGN_UP);
    }

    public static Intent getLoginIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(LOGIN);
    }


}