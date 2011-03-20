package com.google.p.android4personfinder;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PersonFinderUserPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.userpreference);
    }

}
