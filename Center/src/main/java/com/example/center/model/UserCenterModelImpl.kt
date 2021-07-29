package com.example.center.model

import android.os.SystemClock
import com.example.center.callback.RegisterCallBack
import com.example.center.contract.UserCenterContract

/**
 * @Author : August
 * @Time : On 2021/7/29 14:01
 */
class UserCenterModelImpl:UserCenterContract.UserCenterModel {
    override fun register(phoneNumber: String, pwd: String, callback: RegisterCallBack) {
        /**
         * 耗时操作
         */
        SystemClock.sleep(1000)
        callback.success("success")

    }
}