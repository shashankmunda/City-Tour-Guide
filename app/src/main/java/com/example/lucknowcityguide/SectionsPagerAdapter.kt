package com.example.lucknowcityguide

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.lucknowcityguide.PlaceHolderFragment.Companion.newInstance

class SectionsPagerAdapter(fm: FragmentManager?, behavior: Int) : FragmentStatePagerAdapter(
    fm!!, behavior
) {
    override fun getItem(position: Int): Fragment {
        //This method is called to instantiate a new fragment for a particular section
        return newInstance(position + 1)
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            1 -> return "SECTION 1"
            2 -> return "SECTION 2"
            3 -> return "SECTION 3"
        }
        return null
    }

    companion object {
        private const val NUM_ITEMS = 3
    }
}