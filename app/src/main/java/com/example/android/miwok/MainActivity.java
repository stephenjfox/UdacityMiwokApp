/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.example.android.miwok.fragments.VocabFragmentFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        ViewPager _pager = (ViewPager) findViewById(R.id.mainViewPager);

        assert _pager != null;

        _pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem( int position ) {
                switch (position) {
                    case 0:
                        return VocabFragmentFactory.NumbersFragment;
                    case 1:
                        return VocabFragmentFactory.FamilyFragment;
                    case 2:
                        return VocabFragmentFactory.ColorsFragment;
                    case 3:
                        return VocabFragmentFactory.PhrasesFragment;
                }
                return VocabFragmentFactory.PhrasesFragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }

    private void openMyActivity( View view, Class<?> activityLoadClass ) {
        Log.d(TAG, "openMyActivity() called with: " + "view = [" + view + "]");

        // This is just extra logging, so memory's sake
        String _name = getResources().getResourceEntryName(view.getId());
        Log.d(TAG, "openMyActivity: view.id = " + _name);

        Intent i = new Intent(this, activityLoadClass);
        startActivity(i);
    }

}
