package com.ovent.data.net;

import com.ovent.data.entites.EventEntity;
import com.ovent.data.entites.SuccessEntity;
import com.ovent.data.utils.Urls;
import com.ovent.domain.Success;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public interface EventApis {

    @Headers({
            "Content-Type : application/json",
            "Accept : application/json"
    })
    @POST(Urls.CREATE_PRIVATE_EVENT)
    Observable<SuccessEntity> createPrivateEvent(@Body EventEntity userEntity);
}
