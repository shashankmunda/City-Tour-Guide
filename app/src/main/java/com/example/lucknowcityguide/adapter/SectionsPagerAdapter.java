package com.example.lucknowcityguide.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import static com.example.lucknowcityguide.util.PlaceHolderFragment.*;


public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS=3;
    public SectionsPagerAdapter(FragmentManager fm,int behavior){
        super(fm,behavior);
    }
    @Override
    public Fragment getItem(int position) {
        //This method is called to instantiate a new fragment for a particular section
        return newInstance(position+1);
    }
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 1: return "SECTION 1";
            case 2: return "SECTION 2";
            case 3: return "SECTION 3";
        }
        return null;
    }
}
