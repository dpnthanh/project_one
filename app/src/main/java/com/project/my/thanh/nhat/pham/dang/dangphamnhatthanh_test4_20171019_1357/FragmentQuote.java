package com.project.my.thanh.nhat.pham.dang.dangphamnhatthanh_test4_20171019_1357;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nhth1 on 19-Oct-17.
 */

public class FragmentQuote extends Fragment {

    TextView txtQuote, txtEmQuote;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quote, null);

        txtQuote = (TextView) view.findViewById(R.id.textView_Quote_fragment);
        txtEmQuote = (TextView) view.findViewById(R.id.textView_Em_Quocte_fragment);

//        setFont for quote text
        Typeface typefaceQuocte1 = Typeface.createFromAsset(getActivity().getAssets(), "IgniteTheLight.ttf");
        txtQuote.setTypeface(typefaceQuocte1);
        Typeface typefaceEmQuocte1 = Typeface.createFromAsset(getActivity().getAssets(), "GOTHAM-LIGHTITALIC.TTF");
        txtEmQuote.setTypeface(typefaceEmQuocte1);

        if (getArguments() != null) {
            txtQuote.setText(getArguments().getString("quote"));
            txtEmQuote.setText(getArguments().getString("emquote"));
        }

        return view;
    }
}
