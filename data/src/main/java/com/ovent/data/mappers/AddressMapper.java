package com.ovent.data.mappers;

import com.ovent.data.entites.AddressEntity;
import com.ovent.domain.Address;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class AddressMapper {
    public static AddressEntity transform(final Address address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLat(address.getLat());
        addressEntity.setLong(address.getLong());
        return addressEntity;
    }

}
