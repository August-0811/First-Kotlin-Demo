package com.example.center.contract

import com.example.center.callback.RegisterCallBack
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
 * @Time : On 2021/7/28 20:25
 */
interface UserCenterContract {

    interface UserCenterModel: IModel{
        fun register(entitiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
    }


    interface UserCenterView:IVew{
        fun <T> registerSuccess(data:T)

        fun registerFailed(throwable: Throwable)
    }

    /**
     * ??????
     */
    abstract class UserCenterRepository:BaseRepository<UserCenterModel>(){
       abstract fun register(entitiy: UserEntitiy):Observable<BaseRespEntity<RespUserEntity>>
    }


    /**
     * ??????????
     */
    abstract class UserCenterPresenter(view: UserCenterView):BasePresenter<UserCenterRepository,UserCenterView>(view){
        abstract fun register(entitiy: UserEntitiy)
    }

}