package com.example.center.model.api

import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.center.util.Bean.FindEntity
import com.example.center.util.Bean.GoodsListEntity
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @Author : August
 * @Time : On 2021/7/29 21:13
 * 服务器响应的用户实体
 */
interface UserCenterApi {

    @POST("api/User/register")
    fun register(@Body params:UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>


    @POST("api/User/login")
    fun login(@Body params:UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>

    @GET("api/GoodsType/getRecommendTypes")
    fun calssfig() : Observable<RespClassfigEntity>


    @GET("api/Goods/getRecommendGoods?page=1&pagesize=30")
    fun gooslist() : Observable<GoodsListEntity>

    @GET("api/Goods/getGoods?&pageno=1&pagesize=10")
    fun find_goods(@Query("keyword") keyword:String,@Query("type") type:String) : Observable<FindEntity>

}