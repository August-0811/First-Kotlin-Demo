package com.example.center.util

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @Author : August
 * @Time : On 2021/7/30 19:26
 */
class TabUtil(
    private val TabTitle: String,
    private val TabSelectedIcon: Int,
    private val TabUnselectedIcon: Int
) :
    CustomTabEntity {
    override fun getTabTitle(): String {
        return TabTitle
    }

    override fun getTabSelectedIcon(): Int {
        return TabSelectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return TabUnselectedIcon
    }

}