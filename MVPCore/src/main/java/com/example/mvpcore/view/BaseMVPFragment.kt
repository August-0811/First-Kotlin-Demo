package com.example.mvpcore.view

import com.example.mvpcore.BasePresenter

/**
 * @Author : August
 * @Time : On 2021/7/30 19:31
 */
abstract class BaseMVPFragment<P:BasePresenter<*,*>>:BaseFragment() {
    protected lateinit var fPersenter:P

    init {
        fPersenter=createPresenter()
    }

    abstract fun createPresenter(): P
}