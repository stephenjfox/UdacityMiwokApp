package com.example.android.miwok.activities;

import android.app.ActionBar;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.android.miwok.R;
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

    /////////////////////////////
    //      Life Cycle         //
    /////////////////////////////

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ActionBar _actionBar = getActionBar();
        if ( _actionBar != null ) {
            _actionBar.setDisplayHomeAsUpEnabled(true); // to shut up warnings
        }
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

                if (_word.hasAudio()) { // TODO: remove this check?

                    AudioManager _audioManager = (AudioManager) getApplicationContext()
                            .getSystemService(Context.AUDIO_SERVICE);
                    int _requestAudioFocus = _audioManager.requestAudioFocus(mAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (_requestAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mMediaPlayer = MediaPlayer.create(
                                AbstractListActivity.this, _word.getAudioResourceId());

                        mMediaPlayer.start();

                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    // This is a juvenile implementation, but our app doesn't receive intents
    // so it will suffice
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ////////////////////////////////////////////////////////////
    //         AudioFocus.OnAudioFocusChangedListener         //
    ////////////////////////////////////////////////////////////

    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange( int focusChange ) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    if ( mMediaPlayer != null ) {
                        mMediaPlayer.start();
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    if ( mMediaPlayer != null ) {
                        mMediaPlayer.stop();
                        releaseMediaPlayer();
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    if ( mMediaPlayer != null ) {
                        mMediaPlayer.pause();
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    if ( mMediaPlayer != null ) {
                        mMediaPlayer.pause();
                    }
                    break;
                default:
                    releaseMediaPlayer();
            }
        }
    };

    /////////////////////////////
    //         HELPERS         //
    /////////////////////////////

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion( MediaPlayer mp ) {
            releaseMediaPlayer();
        }
    };

    private void logWords() {
        String TAG = this.getClass().getName();
        for ( int i = 0; i < mWords.size(); i++ ) {
            Log.d(TAG, "Word at index " + i + ": " + mWords.get(i));
        }
    }

    private void releaseMediaPlayer() {
        if ( mMediaPlayer != null ) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            AudioManager _am = (AudioManager) getApplicationContext()
                    .getSystemService(Context.AUDIO_SERVICE);
            _am.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}
