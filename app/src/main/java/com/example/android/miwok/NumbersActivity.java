package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.model.WordAdapter;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity
{
    private static final String TAG = NumbersActivity.class.getName();

    private ArrayList<Word> words = new ArrayList<Word>(10) {{
        add(new Word("one", "lutti"));
        add(new Word("two", "otiiko"));
        add(new Word("three", "tolookosu"));
        add(new Word("four", "oyyisa"));
        add(new Word("five", "massokka"));
        add(new Word("six", "temmokka"));
        add(new Word("seven", "kenekaku"));
        add(new Word("eight", "kawinta"));
        add(new Word("nine", "wo'e"));
        add(new Word("ten", "na'aacha"));
    }};

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        logWords();

        AbsListView _listView = (ListView) findViewById(R.id.rootNumbersView);
        // TODO: why doesn't android.R.layout.simple_list_item2 work?
        WordAdapter _adapter = new WordAdapter(this, words);

        _listView.setAdapter(_adapter);
    }

    private void logWords() {
        for ( int i = 0; i < words.size(); i++ ) {
            Log.d(TAG, "Word at index " + i + ": " + words.get(i));
        }
    }
}
