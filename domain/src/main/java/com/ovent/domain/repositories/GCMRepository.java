package com.ovent.domain.repositories;

import com.ovent.domain.GCMTokenRegister;

import rx.Observable;

/**
 * Author : Kunal Chavhan
 * Date : 4/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public interface GCMRepository {
    Observable<GCMTokenRegister> sendToken(final String token,final String deviceId);
}
