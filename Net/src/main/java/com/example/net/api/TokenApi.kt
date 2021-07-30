package com.example.net.api

import com.zy.net.protocol.resp.TokenRespEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @Author : August
 * @Time : On 2021/7/29 20:18
 */
interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("grant_type") grant_type: String?,
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<TokenRespEntity?>?
}