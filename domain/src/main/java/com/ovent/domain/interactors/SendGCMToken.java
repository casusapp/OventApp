package com.ovent.domain.interactors;

import com.ovent.domain.GCMTokenRegister;
import com.ovent.domain.executors.PostExecutionThread;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.repositories.GCMRepository;

import rx.Observable;

/**
 * Author : Kunal Chavhan
 * Date : 4/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class SendGCMToken extends UseCase<GCMTokenRegister>{
    private static String TAG = "##SendGCMToken##";
    private String mToken;
    private String mDeviceId;
    private GCMRepository mGCMRepository;

    public SendGCMToken(final GCMRepository gcmRepository,final String token,final String deviceId,final ThreadExecutor threadExecutor,final PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mGCMRepository = gcmRepository;
        mToken = token;
        mDeviceId = deviceId;
    }

    @Override
    public Observable<GCMTokenRegister> buildUseCaseObservable() {
        return mGCMRepository.sendToken(mToken,mDeviceId);
    }
}
