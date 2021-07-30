package com.example.center.model.api

import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author : August
 * @Time : On 2021/7/29 21:13
 * 服务器响应的用户实体
 */
interface UserCenterApi {

    @POST("api/User/register")
    fun register(@Body params:UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
}