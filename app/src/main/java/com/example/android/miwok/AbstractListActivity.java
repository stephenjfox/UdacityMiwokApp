package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.model.WordAdapter;

import java.util.List;

/**
 * Instead of writing this same basic code (at least) four times, I pulled it
 * into a super type
 * Created by stefox2 on 6/25/16.
 */
public class AbstractListActivity extends AppCompatActivity {
    protected List<Word> mWords;

    public AbstractListActivity(List<Word> targetWords) {
        mWords = targetWords;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        logWords();

        // Be generic and code to an interface
        AbsListView _listView = (ListView) findViewById(R.id.rootListView);

        WordAdapter _adapter = new WordAdapter(this, mWords);

        _listView.setAdapter(_adapter);
    }

    private void logWords() {
        String TAG = this.getClass().getName();
        for ( int i = 0; i < mWords.size(); i++ ) {
            Log.d(TAG, "Word at index " + i + ": " + mWords.get(i));
        }
    }
}
