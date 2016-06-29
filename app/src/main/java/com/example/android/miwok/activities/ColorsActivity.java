package com.example.android.miwok.activities;

import com.example.android.miwok.R;
import com.example.android.miwok.model.WordStore;

public class ColorsActivity extends AbstractListActivity {

    public ColorsActivity() {
        super(WordStore.COLORS_VOCAB,
                R.color.category_colors);
    }
}
