package com.ovent.utils;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import java.net.URI;

/**
 * Created by Kunal on 18/12/15.
 */
public final class Intents {

    private static final String INTENT_PREFIX = "ovent://android";
    private static final Uri HOME = Uri.parse(INTENT_PREFIX + "/home/");
    private static final Uri SIGN_UP = Uri.parse(INTENT_PREFIX + "/sign_up/");
    private static final Uri LOGIN = Uri.parse(INTENT_PREFIX + "/login/");
    private static final Uri SPLASH = Uri.parse(INTENT_PREFIX + "/splash/");
    private static final Uri ACCOUNT = Uri.parse(INTENT_PREFIX + "/account/");
    private static final Uri CREATE_EVENT = Uri.parse(INTENT_PREFIX + "/create_event/");
    private static final Uri CONTACTS_LIST = Uri.parse(INTENT_PREFIX + "/contacts_list/");

    public static Intent getHomeIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(HOME);
    }

    public static Intent getSignUpIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(SIGN_UP);
    }

    public static Intent getLoginIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(LOGIN);
    }

    public static Intent getAccountIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(ACCOUNT);
    }

    public static Intent getCreateEventIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(CREATE_EVENT);
    }

    public static Intent getContactsListIntent(){
        return new Intent(Intent.ACTION_VIEW).setData(CONTACTS_LIST);
    }
}