package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
    protected @ColorRes int mBackgroundColorResource = -1;
    private MediaPlayer mMediaPlayer;

    public AbstractListActivity(List<Word> targetWords) {
        mWords = targetWords;
    }

    public AbstractListActivity( List<Word> targetWords, @ColorRes int colorResource) {
        mWords = targetWords;
        mBackgroundColorResource = colorResource;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        logWords();

        // Be generic and code to an interface
        AbsListView _listView = (ListView) findViewById(R.id.rootListView);

        WordAdapter _adapter = new WordAdapter(this, mWords, mBackgroundColorResource);

        _listView.setAdapter(_adapter);
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int position, long id ) {
                Word _word = mWords.get(position);

                releaseMediaPlayer();

                if (_word.hasAudio()) {
                    mMediaPlayer = MediaPlayer.create(
                            AbstractListActivity.this, _word.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    private void logWords() {
        String TAG = this.getClass().getName();
        for ( int i = 0; i < mWords.size(); i++ ) {
            Log.d(TAG, "Word at index " + i + ": " + mWords.get(i));
        }
    }

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion( MediaPlayer mp ) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if ( mMediaPlayer != null ) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
