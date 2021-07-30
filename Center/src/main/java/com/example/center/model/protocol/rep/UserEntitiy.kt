package com.example.center.model.protocol.rep

/**
 * @Author : August
 * @Time : On 2021/7/29 21:11
 */
data class UserEntitiy(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)