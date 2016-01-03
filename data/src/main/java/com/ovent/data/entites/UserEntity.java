package com.ovent.data.entites;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Kunal on 18/12/15.
 */

public class UserEntity extends RealmObject {
    /**
     * user's basic info
     */
    private String userName;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailAddress;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("address")
    private String address;
    /**
     * user's optional info
     */
    private String profilePicUrl;

    /**
     * user's authentication info
     */
    @SerializedName("auth_key")
    private String authKey;
    @SerializedName("facebook_access_token")
    private String facebookToken;
    @SerializedName("google_plus_id_token")
    private String googlePlusToken;
    @SerializedName("id")
    private String id;
    private boolean isGplus;
    private boolean isFacebook;
    @SerializedName("email_verified")
    private boolean isEmailVerified;
    @SerializedName("phone_number_verified")
    private boolean isPhoneVerified;
    @SerializedName("password")
    private String password;
    private String licenseNumber;
    @SerializedName("facebook_user_id")
    private String facebookUserId;
    private boolean isLoggedIn;

    public UserEntity(){

    }

    /*public UserEntity(final String email, final String password){
        this.email = email;
        this.password = password;
    }*/

    public UserEntity(final String phone, final String password){
        this.phoneNumber = phone;
        this.password = password;
    }

    /**
     * Getter methods
     */
    public String getName(){
        return name;
    }

    public String getUserName(){
        return userName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAuthKey(){
        return authKey;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getFacebookToken(){
        return facebookToken;
    }



    public boolean isEmailVerified(){
        return isEmailVerified;
    }

    public boolean isPhoneVerified(){
        return isPhoneVerified;
    }

    public String getPassword(){
        return password;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress(){
        return address;
    }

    /**
     * Setter functions
     */
    public void setName(final String name){
        this.name = name;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsFacebook(boolean isFacebook) {
        this.isFacebook = isFacebook;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public void setIsPhoneVerified(boolean isPhoneVerified) {
        this.isPhoneVerified = isPhoneVerified;
    }

    public void setPassword(final String password){
        this.password = password;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isFacebook() {
        return isFacebook;
    }

    public String getId() {
        return id;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public String getFacebookUserId() {
        return facebookUserId;
    }

    public void setFacebookUserId(String facebookUserId) {
        this.facebookUserId = facebookUserId;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isGplus() {
        return isGplus;
    }

    public void setIsGplus(boolean isGplus) {
        this.isGplus = isGplus;
    }

    public String getGooglePlusToken() {
        return googlePlusToken;
    }

    public void setGooglePlusToken(String googlePlusToken) {
        this.googlePlusToken = googlePlusToken;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public void setAddress(String address){
        this.address = address;
    }

}