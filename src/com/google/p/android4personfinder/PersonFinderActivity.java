package com.google.p.android4personfinder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PersonFinderActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final boolean debug = true;
    private static final String TAG = "PersonFinderActivity";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
        addPreferencesFromResource(R.xml.userpreference);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.personfinderactivity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        boolean retValue = false;
        switch (item.getItemId()) {
        case R.id.menu_upload_info:
            PersonFinderInfo info = new PersonFinderInfo((Context)this);
            if (debug) {
                Log.d(TAG, info.toString());
            }
            retValue = true;
            break;
        }
        return retValue;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Log.d(TAG, "key: " + key);

        if (key.equals(getString(R.string.source_key))) {
            String value = sharedPreferences.getString(key, getString(R.string.default_source_value));
            Intent intent;
            if (value.equals("0")) { // TODO 綺麗じゃない Refer to R.arrays.source_values
                // This is a new record.
                intent = new Intent(this, PersonFinderSourceNewPreferenceActivity.class);
                startActivity(intent);
            } else if (value.equals("1")) { // TODO 綺麗じゃない Refer to R.arrays.source_values
                // This record is copied from another source.
                intent = new Intent(this, PersonFinderSourceCopiedPreferenceActivity.class);
                startActivity(intent);
            }
        }
    }
}