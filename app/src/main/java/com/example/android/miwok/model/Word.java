package com.example.android.miwok.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;
import android.util.Log;

/**
 * Base model class for encapsulating everything we need to study our foreign
 * language: translation, audio, and image to link your memory
 * Created by stefox2 on 6/23/16.
 */
public class Word implements Parcelable {
    private static final int NO_IMAGE_ID = 0;
    private static final int NO_MEDIA_ID = -1;
    private static final String TAG = Word.class.getName();
    private final String mDefaultTranslation;
    private final String mMiwokTranslation;
    private int mImageResourceId;
    private final int mAudioResourceId;

    public Word( String base, String foreign, @DrawableRes int imageResourceId,
                 @RawRes int audioResourceId) {
        this.mDefaultTranslation = base;
        this.mMiwokTranslation = foreign;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }

    public Word ( String defaultTranslation, String foreignTranslation,
                  @DrawableRes int imageResourceId) {
        this(defaultTranslation, foreignTranslation, imageResourceId, NO_MEDIA_ID);
    }

    protected Word( Parcel in ) {
        mDefaultTranslation = in.readString();
        mMiwokTranslation = in.readString();
        mImageResourceId = in.readInt();
        mAudioResourceId = in.readInt();
        Log.d(TAG, "Word(Parcel) invoked. Result = " + this);
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel( Parcel in ) {
            return new Word(in);
        }

        @Override
        public Word[] newArray( int size ) {
            return new Word[size];
        }
    };

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public static Word withAudio( String defaultTranslation,
                                         String foreignTranslation,
                                         @RawRes int audioResourceId) {
        return new Word(defaultTranslation, foreignTranslation,
                NO_IMAGE_ID, audioResourceId);
    }

    @Override
    public String toString() {
        return String.format("Word{ default=\"%s\", miwok=\"%s\", audioId=%d, imageId=%d }",
                mDefaultTranslation, mMiwokTranslation, mAudioResourceId, mImageResourceId);
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString(mDefaultTranslation);
        dest.writeString(mMiwokTranslation);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mAudioResourceId);
    }

    public boolean hasImage() {
        return this.mImageResourceId != NO_IMAGE_ID;
    }

    public boolean hasAudio() {
        return this.mAudioResourceId != NO_MEDIA_ID;
    }
}
