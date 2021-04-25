package com.example.lucknowcityguide;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

class PagerActivity extends AppCompatActivity{
    /* Local instance of custom PagerAdapter class to provide fragments for each of the sections.*/
    SectionsPagerAdapter mSectionsPagerAdapter;
    /*ViewPager to host the section contents*/
    private ViewPager mViewPager;
    ImageButton mNextBtn;
    Button mSkipBtn,mFinishBtn;

    ImageView zero,one,two;
    ImageView[] indicators;

    CoordinatorLayout mCoordinator;
    private static final String TAG="PagerActivity";
    int page=0;  // to track page position

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blacktrans80));
        setContentView(R.layout.activity_pager);
        /*Set up the fragment pager adapter*/
        mSectionsPagerAdapter=new SectionsPagerAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mNextBtn=findViewById(R.id.intro_btn_next);
        mSkipBtn=findViewById(R.id.intro_btn_skip);
        mFinishBtn=findViewById(R.id.intro_btn_finish);
        zero=findViewById(R.id.intro_indicator_0);
        one=findViewById(R.id.intro_indicator_1);
        two=findViewById(R.id.intro_indicator_2);
        mCoordinator=findViewById(R.id.main_screen);
        indicators=new ImageView[]{zero,one,two};

        //Set up the ViewPager with the sectionsAdapter
        mViewPager=findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setCurrentItem(page);
        updateIndicators(page);
        final int color1=ContextCompat.getColor(this,R.color.cyan);
        final int color2=ContextCompat.getColor(this, R.color.orange);
        final int color3=ContextCompat.getColor(this, R.color.green);
        final int colorList[]={color1,color2,color3};
        final ArgbEvaluator argbEvaluator=new ArgbEvaluator();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*Perform color update*/
                int colorUpdt=(Integer) argbEvaluator.evaluate(positionOffset, colorList[position],colorList[position==2?position:position+1]);
                mViewPager.setBackgroundColor(colorUpdt);
            }
            @Override
            public void onPageSelected(int position) {
                /*Update the parameters and indicators depending on the page selected*/
                page=position;
                updateIndicators(page);
                switch (position){
                    case 0: mViewPager.setBackgroundColor(color1);
                    break;
                    case 1: mViewPager.setBackgroundColor(color2);
                    break;
                    case 2: mViewPager.setBackgroundColor(color3);
                    break;
                }
                mNextBtn.setVisibility(position==2? View.GONE:View.VISIBLE);
                mFinishBtn.setVisibility(position==2?View.VISIBLE:View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page+=1;
                mViewPager.setCurrentItem(page,true);
            }
        });
        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.saveSharedPref(PagerActivity.this, MainActivity.PREF_USER_FIRST_TIME, "false");
                finish();
            }
        });
    }
    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected
            );
        }
    }
}