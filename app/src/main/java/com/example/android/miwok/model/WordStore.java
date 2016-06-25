package com.example.android.miwok.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Statically initialized vocabulary lists, to be loaded by their associated
 * implementations
 * Created by stefox2 on 6/25/16.
 */
public class WordStore {
    public static final List<Word> NUMBERS_VOCAB = new ArrayList<Word>(10) {{
        add(new Word("one", "lutti"));
        add(new Word("two", "otiiko"));
        add(new Word("three", "tolookosu"));
        add(new Word("four", "oyyisa"));
        add(new Word("five", "massokka"));
        add(new Word("six", "temmokka"));
        add(new Word("seven", "kenekaku"));
        add(new Word("eight", "kawinta"));
        add(new Word("nine", "wo'e"));
        add(new Word("ten", "na'aacha"));
    }};

    public static final List<Word> FAMILY_VOCAB = new ArrayList<Word>(10){{
        add(new Word("father", "әpә"));
        add(new Word("mother", "әṭa"));
        add(new Word("son", "angsi"));
        add(new Word("daughter", "tune"));
        add(new Word("older brother", "taachi"));
        add(new Word("younger brother", "chalitti"));
        add(new Word("older sister", "teṭe"));
        add(new Word("younger sister", "kolliti"));
        add(new Word("grandmother", "ama"));
        add(new Word("grandfather", "paapa"));
    }};

    public static final List<Word> COLORS_VOCAB = new ArrayList<Word>(10){{
        add(new Word("red", "weṭeṭṭi"));
        add(new Word("green", "chokokki"));
        add(new Word("brown", "ṭakaakki"));
        add(new Word("gray", "ṭopoppi"));
        add(new Word("black", "kululli"));
        add(new Word("white", "kelelli"));
        add(new Word("dusty yellow", "ṭopiisә"));
        add(new Word("mustard yellow", "chiwiiṭә"));
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
