package com.ovent.presentation.mappers;

import com.ovent.domain.User;
import com.ovent.presentation.models.UserModel;

/**
 * Created by Kunal on 18/12/15.
 */
public final class UserMapper {

    public static UserModel transform(final User user){
        return new UserModel( user.getEmailAddress(),
                 user.getPassword());
    }

    public static User tranform(final UserModel userModel){
        return new User( userModel.getEmail(),
                 userModel.getPassword());
    }
}