package com.example.mvpcore.view

import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew

/**
 * @Author : August
 * @Time : On 2021/7/28 20:03
 */
abstract class BaseMVPActivity <P:BasePresenter<*,*>>: BaseActivity() {
    protected lateinit var mPresenter:P

    init {
        mPresenter = createPresenter()

    }

    abstract fun createPresenter(): P
}