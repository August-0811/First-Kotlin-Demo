package com.example.center.presenter

import android.util.Log
import com.example.center.contract.UserCenterContract
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.center.repoitory.UserCenterRepositoryImpl
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * @Author : August
 * @Time : On 2021/7/29 14:06
 */
class UserCenterPresenterImpl(_view:UserCenterContract.UserCenterView) : UserCenterContract.UserCenterPresenter(_view){

    override fun register(entitiy: UserEntitiy) {
        mRepository.register(entitiy)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<BaseRespEntity<RespUserEntity>>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: BaseRespEntity<RespUserEntity>) {
                    Log.i("777",""+t)
                    mView.get()!!.registerSuccess(t)
                }

                override fun onError(e: Throwable) {
                    Log.i("777",""+e)
                    mView.get()!!.registerFailed(e)
                }

            })

    }


    override fun createRepository(): UserCenterContract.UserCenterRepository {
        return UserCenterRepositoryImpl()
    }


}