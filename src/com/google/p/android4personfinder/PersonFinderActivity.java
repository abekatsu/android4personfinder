package com.google.p.android4personfinder;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PersonFinderActivity extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
        addPreferencesFromResource(R.xml.userpreference);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    
}