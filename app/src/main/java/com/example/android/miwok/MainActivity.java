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

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.example.android.miwok.fragments.VocabFragmentFactory;

import static com.fox.android.view.ViewExtensions.find;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        ViewPager _pager = find(this, R.id.mainViewPager);

        _pager.setAdapter(mPagerAdapter);

        TabLayout _tabLayout = find(this, R.id.mainTabNav);
        _tabLayout.setupWithViewPager(_pager);
    }

    private FragmentPagerAdapter mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        private int[] mImageResIds = {
                R.drawable.number_one,
                R.drawable.family_father,
                R.drawable.color_green,
                R.drawable.ic_play_arrow_black_24dp
        };

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

        @Override
        public CharSequence getPageTitle( int position ) {
            switch (position) {
                case 0:
                    return getString(R.string.category_numbers);
                case 1:
                    return getString(R.string.category_family);
                case 2:
                    return getString(R.string.category_colors);
                case 3:
                    return getString(R.string.category_phrases);
            }
            return null;
        }

        // FIXME: 6/28/16 no images actually draw
        private CharSequence getIconPageTitle( int position ) {
            // Generate title based on item position
            // return tabTitles[position];

            // getDrawable(int i) is deprecated, use getDrawable(int i, Theme theme) for min SDK >=21
            // or ContextCompat.getDrawable(Context context, int id) if you want support for older versions.
            // Drawable image = context.getResources().getDrawable(iconIds[position], context.getTheme());
            // Drawable image = context.getResources().getDrawable(mImageResIds[position]);

            Drawable image = ContextCompat.getDrawable(MainActivity.this, mImageResIds[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sb;

        }
    };

}
