package com.ovent.data.converters;

import android.util.Log;

import com.ovent.data.entites.SuccessEntity;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.Converter;


/**
 * Converter factory for converting success api call
 *
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class SuccessMessageConverter implements Converter<SuccessEntity> {
    private static String TAG = "##SuccessMessageConverter##";
    @Override
    public SuccessEntity fromBody(ResponseBody body) throws IOException {
        String bodyString = body.string();
        Log.d(TAG, bodyString);
        final JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(bodyString);
            return GsonConverter.getInstance().fromJson(jsonObject.toString(),
                    SuccessEntity.class);
        } catch (JSONException e) {
            throw new IOException("Server error!");
        }
    }

    @Override
    public RequestBody toBody(SuccessEntity value) {
        return RequestBody.create(MediaType.parse("application/json"),
                GsonConverter.getInstance().toJson(value, SuccessEntity.class));
    }
}
