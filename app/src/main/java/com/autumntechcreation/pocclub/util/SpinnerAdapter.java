package com.autumntechcreation.pocclub.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


import com.autumntechcreation.pocclub.R;

import java.util.List;


public class SpinnerAdapter extends ArrayAdapter<String> {

    private int selectedPos=0;
    // Initialise custom font, for example:
    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/myriadproregular.ttf");


    // (In reality I used a manager which caches the Typeface objects)
    // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

    public SpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        selectedPos=position;
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);

        if(position==selectedPos) {
//            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21f);
//            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGreen));
//            view.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));

            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f);
            view.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGreen));
        }
        else {
//            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f);
//            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
//            view.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));

            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f);
            view.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
        }
        return view;
    }
}
