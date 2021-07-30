package com.example.center.contract

import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/30 13:39
 */
interface UserLoginContract {

    interface UserCenterModel: IModel {
        fun login(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>>
    }

    abstract class UserCenterRepository: BaseRepository<UserCenterModel>(){
        abstract fun login(entitiy: UserEntitiy): Observable<BaseRespEntity<RespUserEntity>>
    }

    interface UserCenterView: IVew {
        fun <T> loginSuccess(data:T)

        fun loginFailed(throwable: Throwable)
    }

    abstract class UserLoginPresenter(view: UserCenterView):
        BasePresenter<UserCenterRepository, UserCenterView>(view){
        abstract fun login(entitiy: UserEntitiy)
    }

}