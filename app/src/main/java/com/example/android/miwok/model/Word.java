package com.example.android.miwok.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;

/**
 * Base model class for encapsulating everything we need to study our foreign
 * language: translation, audio, and image to link your memory
 * Created by stefox2 on 6/23/16.
 */
public class Word {
    private static final int NO_IMAGE_ID = 0;
    private static final int NO_MEDIA_ID = -1;
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

    public boolean hasImage() {
        return this.mImageResourceId != NO_IMAGE_ID;
    }

    public boolean hasAudio() {
        return this.mAudioResourceId != NO_MEDIA_ID;
    }
}
