package com.example.android.miwok.model;

/**
 * Created by stefox2 on 6/23/16.
 */
public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word( String base, String foreign ) {
        this.mDefaultTranslation = base;
        this.mMiwokTranslation = foreign;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    @Override
    public String toString() {
        return String.format("Word{ default = \"%s\", miwok = \"%s\" }", mDefaultTranslation, mMiwokTranslation);
    }
}
