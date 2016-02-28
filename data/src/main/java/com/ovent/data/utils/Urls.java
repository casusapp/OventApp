package com.ovent.data.utils;

import com.ovent.data.BuildConfig;

/**
 * Created by Kunal on 18/12/15.
 */
public final class Urls {

    // Base url for String
    public static final String STAGING_BASE_URL = "192.168.1.10:8080/";

    /** Base url for production
     * for now this is same as @STAGING_BASE_URL
     */
    public static final String PRODUCTION_BASE_URL = "http://ovent.herokuapp.com/";

    /**
     * @return STAGING_BASE_URL
     */
    public static String GetStagingBaseUrl(){
        return STAGING_BASE_URL;
    }

    /**
     * @return PRODUCTION_BASE_URL
     */
    public static String GetProductionBaseUrl(){
        return PRODUCTION_BASE_URL;
    }

    public static final String LOGIN_USER = "loginuser";

    public static final String CREATE_USER = "user";

    public static final String CREATE_PRIVATE_EVENT = "event/private/create";
    /**
     * Helper function to get BASE_URL. Consumed by retrofit
     * @return base url end point
     */
    public static String GetBaseUrl(){
        if(BuildConfig.DEBUG){
            return GetStagingBaseUrl();
        }
        return GetProductionBaseUrl();
    }
}