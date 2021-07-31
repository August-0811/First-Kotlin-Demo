package com.example.center.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @Author : August
 * @Time : On 2021/7/30 21:16
 */
class FragAda(
    fm: FragmentManager,
    var list: List<Fragment>
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

}