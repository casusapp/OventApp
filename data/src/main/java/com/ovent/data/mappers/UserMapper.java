package com.ovent.data.mappers;

import com.ovent.data.entites.UserEntity;
import com.ovent.domain.User;

import io.realm.Realm;

/**
 * Created by Kunal on 18/12/15.
 */

public final class UserMapper {

    private static final String TAG = "###UserMapper###";

    /**
     * helper function which accept domain User model and returns UserEntity
     *
     * @param user
     * @return user
     */
    public static UserEntity transform(final User user) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getFullName());
        userEntity.setEmail(user.getEmailAddress());
        userEntity.setAuthKey(user.getAuthKey());
        userEntity.setPassword(user.getPassword());
        userEntity.setLicenseNumber(user.getLicenseNumber());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setFacebookToken(user.getFacebookToken());
        userEntity.setFacebookUserId(user.getFacebookId());
        userEntity.setProfilePicUrl(user.getProfilePicUrl());
        userEntity.setIsGplus(user.isGplus());
        userEntity.setIsLoggedIn(user.isLoggedIn());
        userEntity.setGooglePlusToken(user.getGooglePlusToken());
        userEntity.setIsEmailVerified(user.isEmailVerified());
        userEntity.setIsPhoneVerified(user.isPhoneVerified());
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAddress(user.getAddress());
        return userEntity;
    }

    /**
     * helper function which accept data UserEntity and returns User
     *
     * @param userEntity
     * @return user
     */
    public static User transform(final UserEntity userEntity) {
        final User user = new com.ovent.domain.User();
        user.setFullName(userEntity.getName());
        user.setEmailAddress(userEntity.getEmail());
        user.setAuthKey(userEntity.getAuthKey());
        user.setPassword(userEntity.getPassword());
        user.setLicenseNumber(userEntity.getLicenseNumber());
        user.setPhoneNumber(userEntity.getPhoneNumber());

        user.setFacebookToken(userEntity.getFacebookToken());
        user.setFacebookId(userEntity.getFacebookUserId());
        user.setProfilePicUrl(userEntity.getProfilePicUrl());
        user.setIsGplus(userEntity.isGplus());
        user.setIsLoggedIn(userEntity.isLoggedIn());
        user.setGooglePlusToken(userEntity.getGooglePlusToken());
        user.setIsEmailVerified(userEntity.isEmailVerified());
        user.setIsPhoneVerified(userEntity.isPhoneVerified());

        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setAddress(userEntity.getAddress());
        user.setName(userEntity.getName());
        return user;
    }

    /**
     * helper function which accept domain User model and returns UserEntity which is realm compatible
     *
     * @param user
     * @return user
     */
    public static void transformToRealm(final User user) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final UserEntity userEntity = realm.createObject(UserEntity.class);
        userEntity.setName(user.getFullName());
        if (user.getEmailAddress() != null)
            userEntity.setEmail(user.getEmailAddress());
        if (user.getAuthKey() != null)
            userEntity.setAuthKey(user.getAuthKey());
        if (user.getLicenseNumber() != null)
            userEntity.getLicenseNumber();
        if (user.getPassword() != null)
            userEntity.setPassword(user.getPassword());
        if (user.getPhoneNumber() != null)
            userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setIsFacebook(user.isFacebook());
        userEntity.setIsGplus(user.isGplus());
        if (user.getFacebookId() != null)
            userEntity.setFacebookUserId(user.getFacebookId());
        if (user.getFacebookToken() != null)
            userEntity.setFacebookToken(user.getFacebookToken());
        if (user.getProfilePicUrl() != null)
            userEntity.setProfilePicUrl(user.getProfilePicUrl());
        if (user.getGooglePlusToken() != null)
            user.setGooglePlusToken(user.getGooglePlusToken());
        if (user.getAddress() != null)
            userEntity.setAddress(user.getAddress());
        if (user.getEmail() != null)
            userEntity.setEmail(user.getEmail());
        if (user.getId() != null)
            userEntity.setId(user.getId());

        userEntity.setIsLoggedIn(user.isLoggedIn());
        userEntity.setIsEmailVerified(user.isEmailVerified());
        userEntity.setIsPhoneVerified(user.isPhoneVerified());

                realm.commitTransaction();
    }
}