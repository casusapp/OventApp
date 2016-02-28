package com.ovent.domain.interactors;

import com.ovent.domain.Event;
import com.ovent.domain.Success;
import com.ovent.domain.executors.PostExecutionThread;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.repositories.EventRepository;

import rx.Observable;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class CreatePrivateEvent extends UseCase<Success>{
    private EventRepository mEventRepository;
    private Event mEvent;

    public CreatePrivateEvent(final Event event, final EventRepository eventRepository,final ThreadExecutor threadExecutor,final PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mEventRepository = eventRepository;
        mEvent = event;
    }

    @Override
    public Observable<Success> buildUseCaseObservable() {
        return mEventRepository.createPrivateEvent(mEvent);
    }
}
