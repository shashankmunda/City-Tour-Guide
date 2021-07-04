package com.example.lucknowcityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlaceHolderFragment : Fragment() {
    private var imgView: ImageView? = null
    private var bgs = intArrayOf(R.drawable.welcome_page, R.drawable.girltourist, R.drawable.bookmark)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pager, container, false)
        val titles = resources.getStringArray(R.array.section_format)
        val desc = resources.getStringArray(R.array.section_desc)
        val titleView = rootView.findViewById<TextView>(R.id.section_label)
        titleView.text =
            titles[requireArguments().getInt(ARG_SECTION_NUMBER) - 1]
        val descView = rootView.findViewById<TextView>(R.id.desc_text)
        descView.text = desc[requireArguments().getInt(ARG_SECTION_NUMBER) - 1]
        imgView = rootView.findViewById(R.id.section_img)
        imgView!!.setBackgroundResource(bgs[requireArguments().getInt(ARG_SECTION_NUMBER) - 1])
        return rootView
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        /* To return a new instance of the fragment for a given section number*/
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceHolderFragment {
            val fragment = PlaceHolderFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}