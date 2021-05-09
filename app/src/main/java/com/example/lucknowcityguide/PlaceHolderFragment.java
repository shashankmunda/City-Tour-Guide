package com.example.lucknowcityguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PlaceHolderFragment extends Fragment {
    ImageView imgView;
    private static final String ARG_SECTION_NUMBER="section_number";
    private String titles[];
    private String desc[];
    public PlaceHolderFragment(){
    }
    int bgs[]=new int[]{R.drawable.welcome_page,R.drawable.pic_take,R.drawable.bookmark};
    /* To return a new instance of the fragment for a given section number*/
    public static PlaceHolderFragment newInstance(int sectionNumber){
        PlaceHolderFragment fragment=new PlaceHolderFragment();
        Bundle args=new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
       View rootView=inflater.inflate(R.layout.fragment_pager, container,false);
       titles=getResources().getStringArray(R.array.section_format);
       desc=getResources().getStringArray(R.array.section_desc);
        TextView titleView=rootView.findViewById(R.id.section_label);
        titleView.setText(titles[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
        TextView descView=rootView.findViewById(R.id.desc_text);
        descView.setText(desc[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
        imgView=rootView.findViewById(R.id.section_img);
        imgView.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
        return rootView;
    }
}