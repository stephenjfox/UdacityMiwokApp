package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity
{
    private static final String TAG = NumbersActivity.class.getName();

    private ArrayList<String> words = new ArrayList<String>(10) {{
        add("one");
        add("two");
        add("three");
        add("four");
        add("five");
        add("six");
        add("seven");
        add("eight");
        add("nine");
        add("ten");
    }};

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        logWords();

        AbsListView _listView = (ListView) findViewById(R.id.rootNumbersView);
        // TODO: why doesn't android.R.layout.simple_list_item2 work?
        ArrayAdapter<String> _adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);
        // TODO: switch that ^^^ back to custom vocab_list_item
        _listView.setAdapter(_adapter);
    }

    private void logWords() {
        for ( int i = 0; i < words.size(); i++ ) {
            Log.d(TAG, "Word at index " + i + ": " + words.get(i));
        }
    }
}
