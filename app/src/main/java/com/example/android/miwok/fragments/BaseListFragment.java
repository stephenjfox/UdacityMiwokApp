package com.example.android.miwok.fragments;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;
import com.example.android.miwok.model.WordAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseListFragment extends Fragment {
    private static final String WORDS_LIST = "wordsList";
    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String TAG = BaseListFragment.class.getName();

    private List<Word> mWords;
    private @ColorRes int mBackgroundColorResource;
    private MediaPlayer mMediaPlayer;



    public BaseListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colorResource the color for this fragment's view
     * @param targetWords the words we want draw in the list
     * @return A new instance of fragment BaseListFragment.
     */
    public static BaseListFragment newInstance( ArrayList<Word> targetWords, @ColorRes int colorResource ) {
        Log.d(TAG, "newInstance() called with: " + "targetWords = [" + targetWords + "], colorResource = [" + colorResource + "]");
        BaseListFragment fragment = new BaseListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(WORDS_LIST, targetWords);
        args.putInt(BACKGROUND_COLOR, colorResource);
        fragment.setArguments(args);

        Log.d(TAG, "newInstance() returned: " + fragment);

        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: with a bundle" + savedInstanceState);
        if ( getArguments() != null ) {
            mWords = (ArrayList<Word>) getArguments().get(WORDS_LIST);
            mBackgroundColorResource = getArguments().getInt(BACKGROUND_COLOR);
            Log.i(TAG, "onCreate: had arguments to get");
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        Log.i(TAG, "onCreateView: invoked");
        View _inflate = inflater.inflate(R.layout.activity_list_view, container, false);

        Log.i(TAG, "onCreateView: inflated layout - " + _inflate);

        AbsListView _listView = (ListView) _inflate.findViewById(R.id.rootListView);

        if (savedInstanceState != null) {
            ArrayList<Word> wordsList = savedInstanceState.getParcelableArrayList(WORDS_LIST);
            this.mBackgroundColorResource = savedInstanceState.getInt(BACKGROUND_COLOR);
            this.mWords = wordsList;
        }
        Log.i(TAG, "onCreateView: word = " + mWords);
        Log.i(TAG, "onCreateView: bkgRes = " + mBackgroundColorResource);

        WordAdapter _adapter = new WordAdapter(getActivity(), mWords, mBackgroundColorResource);

        _listView.setAdapter(_adapter);
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int position, long id ) {
                Word _word = mWords.get(position);

                releaseMediaPlayer();

                AudioManager _audioManager = (AudioManager) getActivity()
                        .getSystemService(Context.AUDIO_SERVICE);
                int _requestAudioFocus = _audioManager.requestAudioFocus(mAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (_requestAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(
                            BaseListFragment.this.getActivity(), _word.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return _inflate;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
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

    private void releaseMediaPlayer() {
        if ( mMediaPlayer != null ) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            AudioManager _am = (AudioManager) getActivity()
                    .getSystemService(Context.AUDIO_SERVICE);
            _am.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}
