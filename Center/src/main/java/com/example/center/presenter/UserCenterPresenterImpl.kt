package com.example.center.presenter

import com.example.center.callback.RegisterCallBack
import com.example.center.contract.UserCenterContract
import com.example.center.repoitory.UserCenterRepositoryImpl
import com.example.mvpcore.BaseRepository


/**
 * @Author : August
 * @Time : On 2021/7/29 14:06
 */
class UserCenterPresenterImpl(_view:UserCenterContract.UserCenterView) : UserCenterContract.UserCenterPresenter(_view){
    override fun register(phoneNumber: String, pwd: String) {
        mRepository.register(phoneNumber,pwd,object : RegisterCallBack{
            override fun <T> success(data: T) {
                mView.get()!!.registerSuccess(data)
            }

            override fun failed(throwable: Throwable) {
                mView.get()!!.registerFailed(throwable)
            }

        })
    }

    override fun createRepository(): UserCenterContract.UserCenterRepository {
        return UserCenterRepositoryImpl()
    }


}