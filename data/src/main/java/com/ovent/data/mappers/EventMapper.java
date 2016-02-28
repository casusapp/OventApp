package com.ovent.data.mappers;

import com.ovent.data.entites.EventEntity;
import com.ovent.domain.Event;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventMapper {

    public static EventEntity transform(final Event event){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setTitle(event.getTitle());
        eventEntity.setDesscription(event.getDescription());
        eventEntity.setAddress(AddressMapper.transform(event.getAddress()));
        eventEntity.setStartTime(event.getStartTime());
        eventEntity.setEndTime(event.getEndTime());
        return eventEntity;
    }
}
