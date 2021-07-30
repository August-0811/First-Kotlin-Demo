package com.zy.common.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import java.util.*

/**
 *@author:zhangyue
 *@date:2021/7/23
 */
class MyApplication:Application() {


    override fun onCreate() {
        super.onCreate()
        mContext=this
    }

    companion object{
        var mContext:Application?=null
        fun getAppContext(): Context {
            return mContext!!
        }
    }


}