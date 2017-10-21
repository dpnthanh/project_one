package com.project.my.thanh.nhat.pham.dang.dangphamnhatthanh_test4_20171019_1357;

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

public class FragmentCalendar extends Fragment {

    TextView txtDay, txtMonth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar_header, null);

        txtDay = (TextView) view.findViewById(R.id.textView_day_calendar_Fragment);
        txtMonth = (TextView) view.findViewById(R.id.textView_month_calendar_Fragment);

        if(getArguments() != null) {
            txtDay.setText(getArguments().getString("daycount"));
            txtMonth.setText(getArguments().getString("month"));
        }

        return view;
    }
}
