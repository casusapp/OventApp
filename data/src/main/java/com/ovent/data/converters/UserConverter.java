package com.ovent.data.converters;

import android.util.Log;

import com.ovent.data.entites.ErrorEntity;
import com.ovent.data.entites.UserEntity;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.Converter;

/**
 * Created by Kunal on 18/12/15.
 */
public final class UserConverter implements Converter<UserEntity> {

    private static final String TAG = "##UserConverter";

    @Override
    public UserEntity fromBody(ResponseBody body) throws IOException {
        String bodyString = body.string();


        Log.d(TAG, "Got response Body as " + bodyString);

        if (bodyString.contains("model")) {
            final JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(bodyString);
                return GsonConverter.getInstance().fromJson(jsonObject.getJSONObject("model").toString(),
                        UserEntity.class);
            } catch (JSONException e) {

                // Not allowing me to throw JSON Exception..

                throw new IOException("Server error!");
            }
        }
        ErrorEntity errorMessageEntity = GsonConverter.getInstance().fromJson(bodyString, ErrorEntity.class);

     //   Crashlytics.logException(new Throwable(errorMessageEntity.getMessage()));

        throw new IOException(errorMessageEntity.getMessage());
    }


    @Override
    public RequestBody toBody(UserEntity value) {
        return RequestBody.create(MediaType.parse("application/json"), GsonConverter.getInstance().toJson(value, UserEntity.class));
    }
}