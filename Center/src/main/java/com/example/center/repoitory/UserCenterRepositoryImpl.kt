package com.example.center.repoitory

import com.example.center.callback.RegisterCallBack
import com.example.center.contract.UserCenterContract
import com.example.center.model.UserCenterModelImpl

/**
 * @Author : August
 * @Time : On 2021/7/29 14:04
 */
class UserCenterRepositoryImpl : UserCenterContract.UserCenterRepository() {

    override fun createModel(): UserCenterContract.UserCenterModel {
        return UserCenterModelImpl()
    }

    override fun register(phoneNumber: String, pwd: String, callback: RegisterCallBack) {
        /*
        当前网络是否可用
         */
        if (true){
            mModel.register(phoneNumber,pwd,callback)
        }else{

        }
    }

}