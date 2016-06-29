package com.example.android.miwok.fragments;

import android.support.v4.app.Fragment;
import com.example.android.miwok.R;
import com.example.android.miwok.model.WordStore;

/**
 * Created by stefox2 on 6/28/16.
 */
public class VocabFragmentFactory {

    public static final Fragment FamilyFragment = BaseListFragment
            .newInstance(WordStore.FAMILY_VOCAB, R.color.category_family);

    public static final Fragment NumbersFragment = BaseListFragment
            .newInstance(WordStore.NUMBERS_VOCAB, R.color.category_numbers);

    public static final Fragment ColorsFragment = BaseListFragment
            .newInstance(WordStore.COLORS_VOCAB, R.color.category_colors);

    public static final Fragment PhrasesFragment = BaseListFragment
            .newInstance(WordStore.PHRASES_VOCAB, R.color.category_phrases);
}
