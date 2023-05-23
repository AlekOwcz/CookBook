package com.example.cookbookapp

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class CookbookPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val fragmentTitles: MutableList<String> = ArrayList()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun setTitle(position: Int, title: CharSequence) {
        fragmentTitles.add(title.toString())
    }
    fun getTitle(position: Int): String {
        return fragmentTitles[position]
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

}