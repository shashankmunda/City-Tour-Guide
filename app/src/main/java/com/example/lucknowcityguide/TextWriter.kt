package com.example.lucknowcityguide

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextWriter : AppCompatTextView {
    private var mText: CharSequence? = null
    private var mIndex = 0
    private var mDelay: Long = 100

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    )

    private val mHandler = Handler()
    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = mText!!.subSequence(0, mIndex++)
            if (mIndex <= mText!!.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    fun animateText(txt: CharSequence?) {
        mText = txt
        mIndex = 0
        text = ""
        mHandler.removeCallbacks(characterAdder)
        mHandler.postDelayed(characterAdder, mDelay)
    }

    fun setCharacterDelay(millis: Long) {
        mDelay = millis
    }
}