package com.ovent.data.converters;

import com.ovent.data.entites.UserEntity;

import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by Kunal on 18/12/15.
 */
public class OventBaseConverterFactory implements Converter.Factory {

    public static OventBaseConverterFactory create() {
        return new OventBaseConverterFactory();
    }

    @Override
    public Converter<?> get(Type type) {

        if(((Class)type).getCanonicalName().contentEquals(UserEntity.class.getCanonicalName())){
            return new UserConverter();
        }

        throw new RuntimeException("No converter found");
    }
}
