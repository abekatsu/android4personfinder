package com.google.p.android4personfinder;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PersonFinderInfo {
    private Context mContext;

    // Person Finder Info
    private String mFamilyName;
    private String mFamilyAltName;
    private String mGivenName;
    private String mGivenAltName;
    
    // Home address
    private String mStreetName;
    private String mNeighborhood;
    private String mCity;
    private String mState;
    private String mZipcode;
    
    // Description
    private String mDescription;
    
    // Photo
    private String mPhoto;
    
    // Source
    private int mSource;
    // New Source
    private String mSourcePerson;
    private String mSourcePersonPhoneNumberStr;
    private String mSourcePersonEmailAddr;
    // Copied Source
    private String mOriginalSource;
    
    // Copied Source
    
    // private int mStatus;
    private String mStatusString;
    private String mMessage;
    private String mLastLocationString;
    private boolean mHaveTalked = false;
    
    public PersonFinderInfo(Context context) {
        this.mContext = context;
        
        this.mFamilyName = getFamilyName();
        this.mFamilyAltName = getFamilyAltName();
        this.mGivenName = getGivenName();
        this.mGivenAltName = getGivenAltName();
        
        this.mStreetName = getStreetName();
        this.mNeighborhood = getNeighborhood();
        this.mCity = getCity();
        this.mState = getState();
        this.mZipcode = getZipcode();
        
        this.mDescription = getDescription();
        
        this.mPhoto = getPhoto();
        
        this.mSource = getSource();
        this.mSourcePerson = getSourcePerson();
        this.mSourcePersonPhoneNumberStr = getSourcePersonPhoneNumberStr();
        this.mSourcePersonEmailAddr = getSourcePersonEmailAddr();
        this.mOriginalSource = getOriginalSource();
        
        this.mStatusString = getStatusString();
        this.mLastLocationString = getLastLocationString();
        this.mMessage = getMessage();
        this.mHaveTalked = HaveTalkedWithThisPerson();
    }


    private String getPreferencesString(String key, String defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        return preferences.getString(key, defValue);
    }
    
    @SuppressWarnings("unused")
    private boolean getPreferencesBoolean(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        return preferences.getBoolean(key, false);
    }
    
    private boolean getPreferencesBoolean(String key, boolean defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        return preferences.getBoolean(key, defValue);
    }

    private String getFamilyName() {
        String key = this.mContext.getString(R.string.family_name_key);
        return getPreferencesString(key, null);
    }
    
    private String getFamilyAltName() {
        String key = this.mContext.getString(R.string.family_name_key);
        return getPreferencesString(key, null);
    }
    
    private String getGivenName() {
        String key = this.mContext.getString(R.string.given_name_key);
        return getPreferencesString(key, null);
    }
    
    private String getGivenAltName() {
        String key = this.mContext.getString(R.string.given_alt_name_key);
        return getPreferencesString(key, null);
    }
    
    private String getStreetName() {
        String key = this.mContext.getString(R.string.street_name_key);
        return getPreferencesString(key, null);
    }
    
    private String getNeighborhood() {
        String key = this.mContext.getString(R.string.neighborhood_key);
        return getPreferencesString(key, null);
    }
    
    private String getCity() {
        String key = this.mContext.getString(R.string.city_key);
        return getPreferencesString(key, null);
    }
    
    private String getState() {
        String key = this.mContext.getString(R.string.state_key);
        return getPreferencesString(key, null);
    }
    
    private String getZipcode() {
        String key = this.mContext.getString(R.string.zipcode_key);
        return getPreferencesString(key, null);
    }
    
    private String getDescription() {
        String key = this.mContext.getString(R.string.description_key);
        return getPreferencesString(key, null);
    }
    
    private String getPhoto() {
        String key = this.mContext.getString(R.string.photo_key);
        return getPreferencesString(key, null);
    }
    
    private int getSource() {
        String key = this.mContext.getString(R.string.source_key);
        String value_st = getPreferencesString(key, this.mContext.getString(R.string.default_source_value));
        int ret = -1; 
        try {
            ret = Integer.parseInt(value_st);
        } catch (NumberFormatException e) {
            // Nothing to do here.
        }
        return ret;
    }
    
    private String getSourcePerson() {
        String key = this.mContext.getString(R.string.source_person_key);
        return getPreferencesString(key, null);
    }
    
    private String getSourcePersonPhoneNumberStr() {
        String key = this.mContext.getString(R.string.source_person_phone_number_key);
        return getPreferencesString(key, null);
    }
    
    private String getSourcePersonEmailAddr() {
        String key = this.mContext.getString(R.string.source_person_email_address_key);
        return getPreferencesString(key, null);
    }
    
    private String getOriginalSource() {
        String key = this.mContext.getString(R.string.original_author_key);
        return getPreferencesString(key, null);
    }
    
    private String getStatusString() {
        String key = this.mContext.getString(R.string.state_key);
        return getPreferencesString(key, this.mContext.getString(R.string.default_status_value));
    }
    
    private String getLastLocationString() {
        String key = this.mContext.getString(R.string.last_known_location_key);
        return getPreferencesString(key, null);
    }
    
    private String getMessage() {
        String key = this.mContext.getString(R.string.message_key);
        return getPreferencesString(key, null);
    }
    
    public boolean isValid() {
        boolean retValue = false;
        return retValue;
    }

    private boolean HaveTalkedWithThisPerson() {
        String key = this.mContext.getString(R.string.personally_talked_key);
        return getPreferencesBoolean(key, false);
    }

}
