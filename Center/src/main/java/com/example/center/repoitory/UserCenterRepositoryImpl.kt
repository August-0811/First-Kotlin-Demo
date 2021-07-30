package com.example.center.repoitory

import com.example.center.callback.RegisterCallBack
import com.example.center.contract.UserCenterContract
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.center.model.service.UserCenterModelImpl
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/29 14:04
 */
class UserCenterRepositoryImpl : UserCenterContract.UserCenterRepository() {

    override fun register(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        return mModel.register(entitiy)
    }

    override fun createModel(): UserCenterContract.UserCenterModel {
        return UserCenterModelImpl()
    }


}