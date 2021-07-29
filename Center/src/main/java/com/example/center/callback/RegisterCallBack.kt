package com.example.center.callback

/**
 * @Author : August
 * @Time : On 2021/7/28 20:28
 */
interface RegisterCallBack {
    fun <T> success(data:T)

    fun failed(throwable: Throwable)
}