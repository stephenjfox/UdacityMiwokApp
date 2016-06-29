package com.example.android.miwok.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.android.miwok.R;
import com.example.android.miwok.fragments.VocabFragmentFactory;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, VocabFragmentFactory.PhrasesFragment)
                .commit();

    }
}
