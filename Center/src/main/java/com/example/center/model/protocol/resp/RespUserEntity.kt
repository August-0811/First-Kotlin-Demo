package com.example.center.model.protocol.resp

/**
 * @Author : August
 * @Time : On 2021/7/29 21:22
 */
data class RespUserEntity(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)