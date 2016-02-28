package com.ovent.domain.repositories;

import com.ovent.domain.Event;
import com.ovent.domain.Success;



import rx.Observable;


/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public interface EventRepository {
    Observable<Success> createPrivateEvent(final Event event);
}
