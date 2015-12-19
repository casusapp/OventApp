package com.ovent.data.retrofit;
import com.ovent.data.converters.OventBaseConverterFactory;
import com.ovent.data.utils.Urls;

import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Kunal on 18/12/15.
 */
public final class RetrofitFactory {

    private static Retrofit retrofit;

    public static void initRetrofitService() {
        if (retrofit != null)
            return;

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.GetBaseUrl())
                .addConverterFactory(OventBaseConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            throw new NullPointerException("Retrofit instance is null!");
        }
        return retrofit;
    }
}