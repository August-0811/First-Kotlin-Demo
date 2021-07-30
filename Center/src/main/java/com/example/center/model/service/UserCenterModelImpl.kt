package com.example.center.model.service

import com.example.center.contract.UserCenterContract
import com.example.center.model.api.UserCenterApi
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.net.RetrofitFactory
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/29 14:01
 */
class UserCenterModelImpl:UserCenterContract.UserCenterModel {

    override fun register(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        val service = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.register(entitiy)
    }




}