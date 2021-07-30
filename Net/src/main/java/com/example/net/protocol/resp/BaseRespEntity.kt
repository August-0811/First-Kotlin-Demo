package com.example.net.protocol.resp

/**
 * @Author : August
 * @Time : On 2021/7/29 21:19
 */
data class BaseRespEntity<T>(var coda:Int,var data:T,var msg:String) {

}