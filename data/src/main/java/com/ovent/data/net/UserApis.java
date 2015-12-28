package com.ovent.data.net;

import com.ovent.data.entites.UserEntity;
import com.ovent.data.utils.Urls;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Kunal on 18/12/15.
 */
public interface UserApis {

    @Headers({
            "Content-Type : application/json",
            "Accept : application/json"
    })
    @POST(Urls.LOGIN_USER)
    Observable<UserEntity> loginUserByEmail(@Body UserEntity userEntity);

    @Headers({
            "Content-Type : application/json",
            "Accept : application/json"
    })
    @POST(Urls.CREATE_USER)
    Observable<UserEntity> signup(@Body UserEntity userEntity);



}