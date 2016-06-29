package com.example.android.miwok.activities;

import com.example.android.miwok.R;
import com.example.android.miwok.model.WordStore;

public class FamilyActivity extends AbstractListActivity {

    public FamilyActivity() {
        super(WordStore.FAMILY_VOCAB,
                R.color.category_family);
    }
}
