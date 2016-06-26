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
    // TODO: 6/25/16 Need audio files from the course (Multi-screen android apps)
    public static final List<Word> NUMBERS_VOCAB = new ArrayList<Word>(10) {{
        add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
    }};

    public static final List<Word> FAMILY_VOCAB = new ArrayList<Word>(10){{
        add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        add(new Word("daughter", "tune",
                R.drawable.family_daughter, R.raw.family_daughter));
        add(new Word("older brother", "taachi",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        add(new Word("younger brother", "chalitti",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        add(new Word("older sister", "teṭe",
                R.drawable.family_older_sister, R.raw.family_older_sister));
        add(new Word("younger sister", "kolliti",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        add(new Word("grandfather", "paapa",
                R.drawable.family_grandfather, R.raw.family_grandfather));
        add(new Word("grandmother", "ama",
                R.drawable.family_grandmother, R.raw.family_grandmother));
    }};

    public static final List<Word> COLORS_VOCAB = new ArrayList<Word>(10){{
        add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        add(new Word("dusty yellow", "ṭopiisә",
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        add(new Word("mustard yellow", "chiwiiṭә",
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
    }};
    public static final List<Word> PHRASES_VOCAB = new ArrayList<Word>(10) {{
        add(Word.withAudio("What is you name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        add(Word.withAudio("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        add(Word.withAudio("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        add(Word.withAudio("I'm feeling good.", "Kuchi achit", R.raw.phrase_im_feeling_good));
        add(Word.withAudio("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        add(Word.withAudio("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        add(Word.withAudio("Yes, I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        add(Word.withAudio("I'm coming", "әәnәm", R.raw.phrase_im_coming));
        add(Word.withAudio("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        add(Word.withAudio("Come here.", "әnni'nem", R.raw.phrase_come_here));
    }};
}
