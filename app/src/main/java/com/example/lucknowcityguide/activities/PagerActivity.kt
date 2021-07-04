package com.example.lucknowcityguide.activities

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.lucknowcityguide.R
import com.example.lucknowcityguide.SectionsPagerAdapter
import com.example.lucknowcityguide.Utils

class PagerActivity : AppCompatActivity() {
    /* Local instance of custom PagerAdapter class to provide fragments for each of the sections.*/
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    /*ViewPager to host the section contents*/
    private lateinit var mViewPager: ViewPager
    lateinit var mNextBtn: ImageButton
    private lateinit var mSkipBtn: Button
    lateinit var mFinishBtn: Button
    private lateinit var zero: ImageView
    private lateinit var one: ImageView
    private lateinit var two: ImageView
    private lateinit var indicators: Array<ImageView>
    private var mCoordinator: CoordinatorLayout? = null
    var page = 0 // to track page position
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_FULLSCREEN
        window.statusBarColor = ContextCompat.getColor(this, R.color.blacktrans80)
        setContentView(R.layout.activity_pager)
        /*Set up the fragment pager com.example.lucknowcityguide.adapter*/mSectionsPagerAdapter =
            SectionsPagerAdapter(
                supportFragmentManager,
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            )
        mNextBtn = findViewById(R.id.intro_btn_next)
        mSkipBtn = findViewById(R.id.intro_btn_skip)
        mFinishBtn = findViewById(R.id.intro_btn_finish)
        zero = findViewById(R.id.intro_indicator_0)
        one = findViewById(R.id.intro_indicator_1)
        two = findViewById(R.id.intro_indicator_2)
        mCoordinator = findViewById(R.id.main_screen)
        indicators = arrayOf(zero, one, two)

        //Set up the ViewPager with the sectionsAdapter
        mViewPager = findViewById(R.id.container)
        mViewPager.adapter = mSectionsPagerAdapter
        mViewPager.currentItem = page
        updateIndicators(page)
        val color1 = ContextCompat.getColor(this, R.color.cyan)
        val color2 = ContextCompat.getColor(this, R.color.orange)
        val color3 = ContextCompat.getColor(this, R.color.green)
        val colorList = intArrayOf(color1, color2, color3)
        val argbEvaluator = ArgbEvaluator()
        mViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                /*Perform color update*/
                val colorUpdt = argbEvaluator.evaluate(
                    positionOffset,
                    colorList[position],
                    colorList[if (position == 2) position else position + 1]
                ) as Int
                mViewPager.setBackgroundColor(colorUpdt)
            }

            override fun onPageSelected(position: Int) {
                /*Update the parameters and indicators depending on the page selected*/
                page = position
                updateIndicators(page)
                when (position) {
                    0 -> mViewPager.setBackgroundColor(color1)
                    1 -> mViewPager.setBackgroundColor(color2)
                    2 -> mViewPager.setBackgroundColor(color3)
                }
                mNextBtn.visibility = if (position == 2) View.GONE else View.VISIBLE
                mFinishBtn.visibility = if (position == 2) View.VISIBLE else View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        mNextBtn.setOnClickListener {
            page += 1
            mViewPager.setCurrentItem(page, true)
        }
        mSkipBtn.setOnClickListener { finish() }
        mFinishBtn.setOnClickListener {
            Utils.saveSharedPref(this@PagerActivity, HomeActivity.PREF_USER_FIRST_TIME, "false")
            finish()
        }
    }

    private fun updateIndicators(position: Int) {
        for (i in indicators.indices) {
            indicators[i].setBackgroundResource(
                if (i == position) R.drawable.indicator_selected else R.drawable.indicator_unselected
            )
        }
    }
}