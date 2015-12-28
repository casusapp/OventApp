package com.ovent.data.retrofit;
import android.util.Log;

import com.ovent.data.converters.OventBaseConverterFactory;
import com.ovent.data.utils.Urls;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Buffer;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Kunal on 18/12/15.
 */
public final class RetrofitFactory {

    private static Retrofit retrofit;
    private static String TAG="##RetrofitFactory##";
    public static void initRetrofitService() {
        if (retrofit != null)
            return;

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.GetBaseUrl())
                .addConverterFactory(OventBaseConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        retrofit.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                long t1 = System.nanoTime();
                String requestLog = String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers());
                Log.d(TAG, String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()));
                if (request.method().compareToIgnoreCase("post") == 0) {
                    requestLog = "\n" + requestLog + "\n" + bodyToString(request);
                }
                Log.d(TAG, "request" + "\n" + requestLog);

                Response response = chain.proceed(request);
                long t2 = System.nanoTime();

                String responseLog = String.format("Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers());

                String bodyString = response.body().string();

                Log.d("TAG", "response" + "\n" + responseLog + "\n" + bodyString);

                return response.newBuilder()
                        .body(ResponseBody.create(response.body().contentType(), bodyString))
                        .build();
            }
        });
    }

    public static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            throw new NullPointerException("Retrofit instance is null!");
        }
        return retrofit;
    }
}