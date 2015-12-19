package com.ovent.data.utils;

import com.ovent.data.BuildConfig;

/**
 * Created by Kunal on 18/12/15.
 */
public final class Urls {

    // Base url for String
    public static final String STAGING_BASE_URL = "http://ovent.herokuapp.com/api/v1/";

    /** Base url for production
     * for now this is same as @STAGING_BASE_URL
     */
    public static final String PRODUCTION_BASE_URL = "http://ovent.herokuapp.com/api/v1/";

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