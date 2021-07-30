package com.example.center.model.service

import com.example.center.contract.UserLoginContract
import com.example.center.model.api.UserCenterApi
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.net.RetrofitFactory
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/30 13:42
 */
class UserLoginModelImpl: UserLoginContract.UserCenterModel {
    override fun login(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        val create = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return create.login(entitiy)
    }
}