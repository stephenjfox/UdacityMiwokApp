package com.example.android.miwok.model;

/**
 * Created by stefox2 on 6/23/16.
 */
public class Word {
    private static final int NO_IMAGE_ID = 0;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;

    public Word( String base, String foreign, int imageResourceId ) {
        this.mDefaultTranslation = base;
        this.mMiwokTranslation = foreign;
        this.mImageResourceId = imageResourceId;
    }

    public Word( String defaultTranslation, String foreignTranslation ) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = foreignTranslation;
        this.mImageResourceId = NO_IMAGE_ID;
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

    @Override
    public String toString() {
        return String.format("Word{ default = \"%s\", miwok = \"%s\" }", mDefaultTranslation, mMiwokTranslation);
    }

    public boolean hasImage() {
        return this.mImageResourceId != NO_IMAGE_ID;
    }
}
