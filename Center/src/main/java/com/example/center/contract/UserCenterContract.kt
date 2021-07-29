package com.example.center.contract

import com.example.center.callback.RegisterCallBack
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew

/**
 * @Author : August
 * @Time : On 2021/7/28 20:25
 */
interface UserCenterContract {

    interface UserCenterModel: IModel{
        fun register(phoneNumber:String,pwd:String,callback:RegisterCallBack)
    }

    abstract class UserCenterRepository:BaseRepository<UserCenterModel>(){
       abstract fun register(phoneNumber:String,pwd:String,callback:RegisterCallBack)
    }

    interface UserCenterView:IVew{
        fun <T> registerSuccess(data:T)

        fun registerFailed(throwable: Throwable)
    }

    abstract class UserCenterPresenter(view: UserCenterView):BasePresenter<UserCenterRepository,UserCenterView>(view){
        abstract fun register(phoneNumber: String,pwd: String)
    }

}