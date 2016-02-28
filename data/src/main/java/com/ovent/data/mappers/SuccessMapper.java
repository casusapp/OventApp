package com.ovent.data.mappers;

import com.ovent.data.entites.SuccessEntity;
import com.ovent.domain.Success;

/**
 * Author : Kunal Chavhan
 * Date : 22/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class SuccessMapper {
    public static Success transform(final SuccessEntity successEntity){
        Success success = new Success(successEntity.getMessage(),successEntity.isSuccess());
        return success;
    }
}
