package com.example.center.repoitory

import com.example.center.contract.UserLoginContract
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.center.model.service.UserLoginModelImpl
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/30 13:51
 */
class UserLoginRepositoryImpl : UserLoginContract.UserCenterRepository() {
    override fun login(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>> {
        return mModel.login(entitiy)
    }

    override fun createModel(): UserLoginContract.UserCenterModel {
        return UserLoginModelImpl()
    }
}