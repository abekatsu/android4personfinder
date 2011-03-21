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
    
    // private int mStatus;
    private String mStatusString;
    private String mMessage;
    private String mLastLocationString;
    private boolean mHaveTalked = false;
    
    public PersonFinderInfo(Context context) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        
        this.mFamilyName = getFamilyName();
        this.mFamilyAltName = getFamilyAltName();
        this.mGivenName = getGivenName();
        this.mGivenAltName = getGivenAltName();
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
