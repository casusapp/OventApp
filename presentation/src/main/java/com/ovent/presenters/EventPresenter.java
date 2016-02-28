package com.ovent.presenters;

import com.ovent.data.repositories.EventRepository;

import com.ovent.domain.Event;
import com.ovent.domain.Success;
import com.ovent.domain.interactors.CreatePrivateEvent;
import com.ovent.models.EventModel;

import rx.Subscriber;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventPresenter extends Presenter {
    private com.ovent.domain.repositories.EventRepository mEventRepository;
    public EventPresenter(){
        mEventRepository = new com.ovent.data.repositories.EventRepository();
    }
    public void createPrivateEvent(final Event event,final Subscriber<Success> subscriber){
        mSubscriptions.add(new CreatePrivateEvent(event,mEventRepository,mThreadExecutor,mPostExecutionThread).execute(subscriber));
    }
    @Override
    void resume() {
        cancelRunningUseCases();
    }

    @Override
    void pause() {
        cancelRunningUseCases();
    }

    @Override
    void destroy() {
        cancelRunningUseCases();
    }
}
