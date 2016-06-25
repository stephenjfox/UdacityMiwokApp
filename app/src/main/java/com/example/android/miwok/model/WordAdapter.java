package com.example.android.miwok.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.android.miwok.R;

import java.util.List;

/**
 * Created by stefox2 on 6/25/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter( Context context, Word[] words ) {
        super(context, 0, words);
    }

    public WordAdapter( Context context, List<Word> words ) {
        super(context, 0, words);
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        View _listItemView = convertView;
        if (_listItemView == null) {
            _listItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.vocab_list_item, parent, false);
        }

        Word _word = getItem(position);

        // Get the first TextView
        TextView foreignTextView = (TextView) _listItemView.findViewById(R.id.foreignText);
        // Set its text
        foreignTextView.setText(_word.getMiwokTranslation());

        // Get the other TextView
        TextView nativeTextView = (TextView) _listItemView.findViewById(R.id.nativeText);
        // Set its text
        nativeTextView.setText(_word.getDefaultTranslation());

        return _listItemView;
    }
}
