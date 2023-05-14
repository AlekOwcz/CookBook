package com.example.cookbookapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class CookbookPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList: MutableList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun setTitle(position: Int, title: CharSequence) {
        (fragmentList[position] as? Titleable)?.title = title
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    interface Titleable {
        var title: CharSequence
    }
}