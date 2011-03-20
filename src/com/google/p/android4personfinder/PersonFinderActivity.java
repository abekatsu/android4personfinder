package com.google.p.android4personfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PersonFinderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        // TODO check the current setting ユーザが設定されているかどうか。
        Intent intent = new Intent(this, PersonFinderUserPreferenceActivity.class);
        startActivity(intent);
    }
    
    
}