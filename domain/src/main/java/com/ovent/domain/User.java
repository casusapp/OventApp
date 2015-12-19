package com.ovent.domain;

/**
 * Created by Kunal on 18/12/15.
 */
public final class User {

    /**
     * user's basic info
     */
    private String mUserName;
    private String mFirstName;
    private String mLastName;
    private String mName;
    private String mFullName;
    private String mEmailAddress;
    private String mPhoneNumber;
    private String mDrivingLicenseUrl;
    private String mEmail;

    /**
     * user's optional info
     */
    private String mProfilePicUrl;

    /**
     * user's authentication info
     */
    private String mAuthKey;
    private String mFacebookToken;
    private String mGooglePlusToken;
    private String mId;
    private boolean mIsFacebook;
    private boolean mIsGplus;
    private boolean mIsEmailVerified;
    private boolean mIsPhoneVerified;
    private String mPassword;
    private String mLicenseNumber;
    private String mFacebookId;
    private String mSiteId;
    private String mAddress;
    private boolean mIsLoggedIn;

    public User() {

    }

    public User(final String email, final String password) {
        mEmailAddress = email;
        mPassword = password;
    }

    public User(final String fullName, final String email, final String phoneNumber,
                final String password, final String licenceNumber, final String licenceUrl){
        mFullName = fullName;
        mEmailAddress = email;
        mPhoneNumber = phoneNumber;
        mPassword = password;
        mLicenseNumber = licenceNumber;
        mDrivingLicenseUrl = licenceUrl;
    }


    /**
     * Getter methods
     */
    public String getFullName(){
        return mFullName;
    }

    public String getUserName(){
        return mUserName;
    }

    public String getFirstName(){
        return mFirstName;
    }

    public String getLastName(){
        return mLastName;
    }

    public String getAuthKey(){
        return mAuthKey;
    }

    public String getEmailAddress(){
        return mEmailAddress;
    }

    public String getPhoneNumber(){
        return mPhoneNumber;
    }

    public String getFacebookToken(){
        return mFacebookToken;
    }

    public String getDrivingLicenseUrl(){
        return mDrivingLicenseUrl;
    }

    public boolean isEmailVerified(){
        return mIsEmailVerified;
    }

    public boolean isPhoneVerified(){
        return mIsPhoneVerified;
    }


    public String getPassword(){
        return mPassword;
    }

    public String getLicenseNumber(){
        return mLicenseNumber;
    }

    public String getSiteId(){ return mSiteId; }

    public String getName(){
        return mName;
    }

    public String getAddress(){
        return mAddress;
    }

    public String getEmail(){
        return mEmail;
    }
    public String getId(){
        return mId;
    }
    /**
     * Setter functions
     */
    public void setFullName(final String fullName){
        mFullName = fullName;
    }


    public void setUserName(String userName) {
        mUserName = userName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        mEmailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public void setDrivingLicenseUrl(String drivingLicenseUrl) {
        mDrivingLicenseUrl = drivingLicenseUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        mProfilePicUrl = profilePicUrl;
    }

    public void setAuthKey(String authKey) {
        mAuthKey = authKey;
    }

    public void setFacebookToken(String facebookToken) {
        mFacebookToken = facebookToken;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        mIsEmailVerified = isEmailVerified;
    }

    public void setIsPhoneVerified(boolean isPhoneVerified) {
        mIsPhoneVerified = isPhoneVerified;
    }


    public void setPassword(final String password){
        mPassword = password;
    }

    public void setLicenseNumber(final String licenseNumber){
        mLicenseNumber = licenseNumber;
    }

    public void setSiteId(final String siteId){mSiteId = siteId; }

    public void setName(String name){
        mName = name;
    }

    public void setAddress(String address){
        mAddress = address;
    }

    public void setEmail(String email){
        mEmail = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserName='" + mUserName + '\'' +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mFullName='" + mFullName + '\'' +
                ", mEmailAddress='" + mEmailAddress + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mDrivingLicenseUrl='" + mDrivingLicenseUrl + '\'' +
                ", mProfilePicUrl='" + mProfilePicUrl + '\'' +
                ", mAuthKey='" + mAuthKey + '\'' +
                ", mFacebookToken='" + mFacebookToken + '\'' +
                ", mGooglePlusToken='" + mGooglePlusToken + '\'' +
                ", mId='" + mId + '\'' +
                ", mIsFacebook=" + mIsFacebook +
                ", mIsGplus=" + mIsGplus +
                ", mIsEmailVerified=" + mIsEmailVerified +
                ", mIsPhoneVerified=" + mIsPhoneVerified +
                ", mPassword='" + mPassword + '\'' +
                ", mLicenseNumber='" + mLicenseNumber + '\'' +
                ", mFacebookId='" + mFacebookId + '\'' +
                ", mSiteNumber='" + mSiteId + '\'' +
                ", mIsLoggedIn=" + mIsLoggedIn +
                '}';
    }

    public String getFacebookId() {
        return mFacebookId;
    }

    public void setFacebookId(String facebookId) {
        mFacebookId = facebookId;
    }

    public String getProfilePicUrl() {
        return mProfilePicUrl;
    }

    public boolean isLoggedIn() {
        return mIsLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        mIsLoggedIn = isLoggedIn;
    }

    public boolean isFacebook() {
        return mIsFacebook;
    }

    public void setIsFacebook(boolean isFacebook) {
        mIsFacebook = isFacebook;
    }

    public boolean isGplus() {
        return mIsGplus;
    }

    public void setIsGplus(boolean isGplus) {
        mIsGplus = isGplus;
    }

    public String getGooglePlusToken() {
        return mGooglePlusToken;
    }

    public void setGooglePlusToken(String googlePlusToken) {
        mGooglePlusToken = googlePlusToken;
    }
}