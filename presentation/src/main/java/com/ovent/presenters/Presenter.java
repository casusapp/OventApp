package com.ovent.presenters;

import android.support.annotation.NonNull;

import com.ovent.domain.executors.PostExecutionThread;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.interactors.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * This presenter class will communicate with data layer using use cases defined in the domain module
 *
 * @author : Kunal Chavhan
 * @date : 18/12/15 : 12:05 AM
 */

public abstract class Presenter {
    protected List<UseCase> mSubscriptions = new ArrayList<>();
    private ExecutorService mExecutors = Executors.newFixedThreadPool(2);
    protected ThreadExecutor mThreadExecutor = new ThreadExecutor() {
        @Override
        public void execute(@NonNull final Runnable runnable) {
            mExecutors.execute(runnable);
        }
    };
    protected PostExecutionThread mPostExecutionThread = new PostExecutionThread() {
        @Override
        public Scheduler getScheduler() {
            return AndroidSchedulers.mainThread();
        }
    };

    protected void cancelRunningUseCases(){
        for(UseCase useCase: mSubscriptions){
            useCase.unsubscribe();
        }
    }

    abstract void resume();

    abstract void pause();

    abstract void destroy();
}