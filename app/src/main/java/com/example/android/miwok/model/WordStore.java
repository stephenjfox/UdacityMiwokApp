package com.example.android.miwok.model;

import com.example.android.miwok.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Statically initialized vocabulary lists, to be loaded by their associated
 * implementations
 * Created by stefox2 on 6/25/16.
 */
public class WordStore {
    public static final List<Word> NUMBERS_VOCAB = new ArrayList<Word>(10) {{
        add(new Word("one", "lutti", R.drawable.number_one));
        add(new Word("two", "otiiko", R.drawable.number_two));
        add(new Word("three", "tolookosu", R.drawable.number_three));
        add(new Word("four", "oyyisa", R.drawable.number_four));
        add(new Word("five", "massokka", R.drawable.number_five));
        add(new Word("six", "temmokka", R.drawable.number_six));
        add(new Word("seven", "kenekaku", R.drawable.number_seven));
        add(new Word("eight", "kawinta", R.drawable.number_eight));
        add(new Word("nine", "wo'e", R.drawable.number_nine));
        add(new Word("ten", "na'aacha", R.drawable.number_ten));
    }};

    public static final List<Word> FAMILY_VOCAB = new ArrayList<Word>(10){{
        add(new Word("father", "әpә", R.drawable.family_father));
        add(new Word("mother", "әṭa", R.drawable.family_mother));
        add(new Word("son", "angsi", R.drawable.family_son));
        add(new Word("daughter", "tune", R.drawable.family_daughter));
        add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        add(new Word("grandmother", "ama", R.drawable.family_grandfather));
        add(new Word("grandfather", "paapa", R.drawable.family_grandmother));
    }};

    public static final List<Word> COLORS_VOCAB = new ArrayList<Word>(10){{
        add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        add(new Word("green", "chokokki", R.drawable.color_green));
        add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        add(new Word("black", "kululli", R.drawable.color_black));
        add(new Word("white", "kelelli", R.drawable.color_white));
        add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
    }};
    public static final List<Word> PHRASES_VOCAB = new ArrayList<Word>(10) {{
        add(new Word("Where are you going?", "minto wuksus"));
        add(new Word("What is you name?", "tinnә oyaase'nә"));
        add(new Word("My name is...", "oyaaset..."));
        add(new Word("How are you feeling?", "michәksәs?"));
        add(new Word("I'm feeling good.", "Kuchi achit"));
        add(new Word("Are you coming?", "әәnәs'aa?"));
        add(new Word("Yes, I'm coming.", "hәә’ әәnәm"));
        add(new Word("I'm coming", "әәnәm"));
        add(new Word("Let's go.", "yoowutis"));
        add(new Word("Come here.", "әnni'nem"));
    }};
}
