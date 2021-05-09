package com.example.lucknowcityguide;


import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class TextWriter extends AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    private long mDelay=100;
    public TextWriter(Context context) {
        super(context);
    }
    public TextWriter(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    private Handler mHandler=new Handler();
    private Runnable characterAdder=new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex<=mText.length()){
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };
    public void animateText(CharSequence txt){
        mText=txt;
        mIndex=0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }
    public void setCharacterDelay(long millis){
        mDelay=millis;
    }
}
