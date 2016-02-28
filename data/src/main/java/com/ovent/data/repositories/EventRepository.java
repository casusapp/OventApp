package com.ovent.data.repositories;

import com.ovent.data.entites.EventEntity;
import com.ovent.data.entites.SuccessEntity;
import com.ovent.data.mappers.EventMapper;
import com.ovent.data.mappers.SuccessMapper;
import com.ovent.data.net.EventApis;
import com.ovent.data.net.UserApis;
import com.ovent.data.retrofit.RetrofitFactory;
import com.ovent.domain.Event;
import com.ovent.domain.Success;

import rx.Observable;
import rx.functions.Func1;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventRepository implements com.ovent.domain.repositories.EventRepository {
    private EventApis mEventApis;

    public EventRepository() {
        mEventApis = RetrofitFactory.getInstance().create(EventApis.class);
    }

    @Override
    public Observable<Success> createPrivateEvent(Event event) {
        EventEntity eventEntity = EventMapper.transform(event);
        return mEventApis.createPrivateEvent(eventEntity).map(new Func1<SuccessEntity, Success>() {
            @Override
            public Success call(SuccessEntity successEntity) {
                return SuccessMapper.transform(successEntity);
            }
        });
    }
}
