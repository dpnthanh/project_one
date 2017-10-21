package com.project.my.thanh.nhat.pham.dang.dangphamnhatthanh_test4_20171019_1357;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.RotateDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBarTest;
    Toolbar toolbar;
    ViewPager viewPagerCalender, viewPagerQuote;
    String[] listDay, listMonth;
    RadioGroup raRadioGroupQuote;
    TextView txtTitleMoveGoal,
            txtHourMoveGoal,
            txtSessionMoveGoal,
            txtStartMoveGoal,
            txtTitleAnleneGoal,
            txtHourAnleneGoal,
            txtinfo0AnleneGoal,
            txtinfo1AnleneGoal,
            txtCountMilk,
            txtCountYaout,
            txtCountConcentrate,
            txtprogressMoveGoal1,
            txtprogressMoveGoal2,
            txtprogressMoveGoal3,
            txtprogressAnleneGoal1,
            txtprogressAnleneGoal2,
            txtprogressAnleneGoal3;
    RadioButton rbQuote0, rbQuote1;
    ImageButton imageButtonCancelError,
            imageButtonMilkUp, imageButtonMilkDown,
            imageButtonYaoutUp, imageButtonYaoutDown,
            imageButtonConcentrateUp, imageButtonConcentrateDown;
    ImageView imageViewMilk, imageViewYaout, imageViewConcentrate,
            imageViewArrowLeft, imageViewArrowRight;
    int intCountMilk = 0,
            intCountYaout = 0,
            intCountConcentrate = 0;
    SeekBar seekBarMoveGoal, seekBarAnleneGoal;
    ProgressBar progressBarCircleMoveGoal,
            progressBarTickMoveGoal,
            progressBarCircleAnleneGoal,
            progressBarTickAnleneGoal;

    LinearLayout linearLayoutError,
            linearLayoutTextProgressMoveGoal,
            linearLayoutTextProgressAnleneGoal;
    FrameLayout frameLayoutSeekbarMoveGoal,
            frameLayoutSeekbarAnleneGoal;
    Handler progressHandle = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiColtrol();
        initDisplay();
        initEvent();

    }

    private void initEvent() {

        imageButtonCancelError.setOnClickListener(this);

        imageViewArrowLeft.setOnClickListener(this);
        imageViewArrowRight.setOnClickListener(this);
        rbQuote0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                viewPagerQuote.setCurrentItem(0);
            }
        });
        rbQuote1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                viewPagerQuote.setCurrentItem(1);
            }
        });
        imageButtonMilkUp.setOnClickListener(this);
        imageButtonMilkDown.setOnClickListener(this);
        imageButtonYaoutUp.setOnClickListener(this);
        imageButtonYaoutDown.setOnClickListener(this);
        imageButtonConcentrateUp.setOnClickListener(this);
        imageButtonConcentrateDown.setOnClickListener(this);

        seekBarMoveGoal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onProgressChanged(SeekBar seekBar, final int i, boolean b) {
                progressBarTickMoveGoal.setProgress(i);
                progressBarCircleMoveGoal.setProgress(i);
                linearLayoutTextProgressMoveGoal.setAlpha((float) (1 - 0.02*i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarAnleneGoal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBarTickAnleneGoal.setProgress(i);
                progressBarTickAnleneGoal.setProgress(i);
                linearLayoutTextProgressAnleneGoal.setAlpha((float) (1 - 0.02*i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void initDisplay() {
        //show toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        MyAdapterCalendar myAdapterCalendar = new MyAdapterCalendar(getSupportFragmentManager());
        viewPagerCalender.setAdapter(myAdapterCalendar);
        viewPagerCalender.setCurrentItem(4);

        MyAdapterQuote myAdapterQuote = new MyAdapterQuote(getSupportFragmentManager());
        viewPagerQuote.setAdapter(myAdapterQuote);

        //set Font
        Typeface typefaceFontDinCondensedBlod = Typeface.createFromAsset(getAssets(), "DIN Pro Condensed Bold.otf");
        Typeface typefaceFontGothamLight = Typeface.createFromAsset(getAssets(), "GOTHAM-LIGHT.TTF");
        txtTitleMoveGoal.setTypeface(typefaceFontDinCondensedBlod);
        txtHourMoveGoal.setTypeface(typefaceFontDinCondensedBlod);
        txtSessionMoveGoal.setTypeface(typefaceFontGothamLight);
        txtStartMoveGoal.setTypeface(typefaceFontGothamLight);
        txtTitleAnleneGoal.setTypeface(typefaceFontDinCondensedBlod);
        txtHourAnleneGoal.setTypeface(typefaceFontDinCondensedBlod);
        txtinfo0AnleneGoal.setTypeface(typefaceFontGothamLight);
        txtinfo1AnleneGoal.setTypeface(typefaceFontGothamLight);

        txtprogressMoveGoal1.setTypeface(typefaceFontDinCondensedBlod);
        txtprogressMoveGoal2.setTypeface(typefaceFontDinCondensedBlod);
        txtprogressMoveGoal3.setTypeface(typefaceFontDinCondensedBlod);

        txtprogressAnleneGoal1.setTypeface(typefaceFontDinCondensedBlod);
        txtprogressAnleneGoal2.setTypeface(typefaceFontDinCondensedBlod);
        txtprogressAnleneGoal3.setTypeface(typefaceFontDinCondensedBlod);

        frameLayoutSeekbarAnleneGoal.setVisibility(View.GONE);

        raRadioGroupQuote.check(R.id.radio_Quote1_main);

    }

    @SuppressLint("StaticFieldLeak")
    private void intiColtrol() {

        imageButtonCancelError = (ImageButton) findViewById(R.id.imageButton_cancel_error_main);
        linearLayoutError = (LinearLayout) findViewById(R.id.linearLayout_error);

        toolbar = (Toolbar) findViewById(R.id.toolbar_custom);
        viewPagerCalender = (ViewPager) findViewById(R.id.viewPager_calendar);
        viewPagerQuote = (ViewPager) findViewById(R.id.viewPager_quote);
        raRadioGroupQuote = (RadioGroup) findViewById(R.id.radioGroupQuote);
        rbQuote0 = (RadioButton) findViewById(R.id.radio_Quote1_main);
        rbQuote1 = (RadioButton) findViewById(R.id.radio_Quote0_main);


        imageViewArrowLeft = (ImageView) findViewById(R.id.imageView_ArrowLeft_main);
        imageViewArrowRight = (ImageView) findViewById(R.id.imageView_ArrowRight_main);


        txtTitleMoveGoal = (TextView) findViewById(R.id.textView_title_moveGoal_main);
        txtHourMoveGoal = (TextView) findViewById(R.id.textView_hour_move_goal_main);
        txtSessionMoveGoal = (TextView) findViewById(R.id.textView_session_move_goal_main);
        txtStartMoveGoal = (TextView) findViewById(R.id.textView_start_move_goal_main);
        txtTitleAnleneGoal = (TextView) findViewById(R.id.textView_title_anlene_goal_main);
        txtHourAnleneGoal = (TextView) findViewById(R.id.textView_hour_anlene_goal_main);
        txtinfo0AnleneGoal = (TextView) findViewById(R.id.textView_info1_anlene_goal_main);
        txtinfo1AnleneGoal = (TextView) findViewById(R.id.textView_info2_anlene_goal_main);


        txtCountMilk = (TextView) findViewById(R.id.textView_Milk_Count_main);
        txtCountYaout = (TextView) findViewById(R.id.textView_yaout_Count_main);
        txtCountConcentrate = (TextView) findViewById(R.id.textView_concentrate_Count_main);

        txtprogressMoveGoal1 = (TextView) findViewById(R.id.textView1_progress_moveGoal);
        txtprogressMoveGoal2 = (TextView) findViewById(R.id.textView2_progress_moveGoal);
        txtprogressMoveGoal3 = (TextView) findViewById(R.id.textView3_progress_moveGoal);

        txtprogressAnleneGoal1 = (TextView) findViewById(R.id.textView1_progress_anleneGoal);
        txtprogressAnleneGoal2 = (TextView) findViewById(R.id.textView2_progress_anleneGoal);
        txtprogressAnleneGoal3 = (TextView) findViewById(R.id.textView3_progress_anleneGoal);

        imageButtonMilkUp = (ImageButton) findViewById(R.id.imageButton_up_milk);
        imageButtonMilkDown = (ImageButton) findViewById(R.id.imageButton_down_milk);
        imageButtonYaoutUp = (ImageButton) findViewById(R.id.imageButton_up_yaout);
        imageButtonYaoutDown = (ImageButton) findViewById(R.id.imageButton_down_yaout);
        imageButtonConcentrateUp = (ImageButton) findViewById(R.id.imageButton_up_concentrate);
        imageButtonConcentrateDown = (ImageButton) findViewById(R.id.imageButton_down_concentrate);

        imageViewMilk = (ImageView) findViewById(R.id.imageView_icon_milk_main);
        imageViewYaout = (ImageView) findViewById(R.id.imageView_icon_yaout_main);
        imageViewConcentrate = (ImageView) findViewById(R.id.imageView_icon_concentrate_main);

        frameLayoutSeekbarMoveGoal = (FrameLayout) findViewById(R.id.frameLayout_seekbar_moveGoal_main);
        frameLayoutSeekbarAnleneGoal = (FrameLayout) findViewById(R.id.frameLayout_seekbar_anleneGoal_main);

        seekBarMoveGoal = (SeekBar) findViewById(R.id.seekbar_moveGoal_main);
        progressBarCircleMoveGoal = (ProgressBar) findViewById(R.id.ProgressBar_circle_moveGoal_main);
        progressBarTickMoveGoal = (ProgressBar) findViewById(R.id.ProgressBar_tick_moveGoal_main);

        seekBarAnleneGoal = (SeekBar) findViewById(R.id.seekbar_anleneGoal_main);
        progressBarCircleAnleneGoal = (ProgressBar) findViewById(R.id.ProgressBar_circle_anleneGoal_main);
        progressBarTickAnleneGoal =  (ProgressBar) findViewById(R.id.ProgressBar_tick_anleneGoal_main);

        progressBarCircleMoveGoal.setMax(100);
        progressBarTickMoveGoal.setMax(100);

        linearLayoutTextProgressMoveGoal = (LinearLayout) findViewById(R.id.linearLayout_progress_moveGoal);
        linearLayoutTextProgressAnleneGoal = (LinearLayout) findViewById(R.id.linearLayout_progress_anleneGoal);


        listDay = new String[]{
                "Day 01",
                "Day 02",
                "Day 03",
                "Day 04",
                "Today, Day 05",
                "Day 06",
                "Day 07",
                "Day 08",
                "Day 09",
                "Day 10"

        };
        listMonth = new String[]{
                "04 Mar",
                "05 Mar",
                "06 Mar",
                "07 Mar",
                "08 Mar",
                "09 Mar",
                "10 Mar",
                "11 Mar",
                "12 Mar",
                "13 Mar"

        };

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton_cancel_error_main:
                linearLayoutError.setVisibility(View.GONE);
                break;
            case R.id.imageView_ArrowLeft_main:
                    viewPagerCalender.setCurrentItem(viewPagerCalender.getCurrentItem() - 1);
                break;
            case R.id.imageView_ArrowRight_main:
                    viewPagerCalender.setCurrentItem(viewPagerCalender.getCurrentItem() + 1);
                break;
            case R.id.imageButton_up_milk:

                intCountMilk++;
                txtCountMilk.setText(intCountMilk + "x");
                if(intCountMilk == 1){
                    imageViewMilk.setImageResource(R.drawable.icon_milk_count);
                }

                break;
            case R.id.imageButton_down_milk:
                if(intCountMilk > 1) {
                    intCountMilk --;
                    txtCountMilk.setText(intCountMilk + "x");
                } else {
                    intCountMilk = 0;
                    txtCountMilk.setText("");
                    imageViewMilk.setImageResource(R.drawable.icon_milk_none);
                }
                break;

            case R.id.imageButton_up_yaout:

                intCountYaout++;
                txtCountYaout.setText(intCountYaout + "x");
                if(intCountYaout == 1){
                    imageViewYaout.setImageResource(R.drawable.icon_yaout_count);
                }

                break;
            case R.id.imageButton_down_yaout:

                if(intCountYaout > 1) {
                    intCountYaout --;
                    txtCountYaout.setText(intCountYaout + "x");
                } else {
                    intCountYaout = 0;
                    txtCountYaout.setText("");
                    imageViewYaout.setImageResource(R.drawable.icon_yaout_none);
                }

                break;
            case R.id.imageButton_up_concentrate:

                intCountConcentrate++;
                txtCountConcentrate.setText(intCountConcentrate + "x");
                if(intCountConcentrate == 1){
                    imageViewConcentrate.setImageResource(R.drawable.icon_concentrate_count);
                }

                break;
            case R.id.imageButton_down_concentrate:

                if(intCountConcentrate > 1) {
                    intCountConcentrate --;
                    txtCountConcentrate.setText(intCountConcentrate + "x");
                } else {
                    intCountConcentrate = 0;
                    txtCountConcentrate.setText("");
                    imageViewConcentrate.setImageResource(R.drawable.icon_concentrate_none);
                }

                break;

        }
        showSeekbarAnleneGoal();

    }

    public class MyAdapterCalendar extends FragmentStatePagerAdapter {
        public MyAdapterCalendar(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            FragmentCalendar fragmentCalendar = new FragmentCalendar();
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 1:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 2:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 3:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 4:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 5:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 6:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 7:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 8:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
                case 9:
                    bundle.putString("daycount", listDay[position]);
                    bundle.putString("month", listMonth[position]);
                    fragmentCalendar.setArguments(bundle);
                    return fragmentCalendar;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 10;
        }
    }

    public class MyAdapterQuote extends FragmentStatePagerAdapter {
        public MyAdapterQuote(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            FragmentQuote fragmentQuote = new FragmentQuote();
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:

                    String quote = getResources().getString(R.string.quote0_main);
                    String emquote = getResources().getString(R.string.em_quocte0_main);
                    bundle.putString("quote", quote);
                    bundle.putString("emquote", emquote);
                    fragmentQuote.setArguments(bundle);
                    return fragmentQuote;
                case 1:
                    String quote1 = getResources().getString(R.string.quote1_main);
                    String emquote1 = getResources().getString(R.string.em_quocte1_main);
                    bundle.putString("quote", quote1);
                    bundle.putString("emquote", emquote1);
                    fragmentQuote.setArguments(bundle);
                    return fragmentQuote;
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
    private void showSeekbarAnleneGoal(){
        if (intCountMilk !=0 || intCountYaout != 0 || intCountConcentrate != 0){
            frameLayoutSeekbarAnleneGoal.setVisibility(View.VISIBLE);
        } else {
            frameLayoutSeekbarAnleneGoal.setVisibility(View.GONE);
        }
    }

}

