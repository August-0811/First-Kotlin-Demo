package com.example.center.presenter

import com.example.center.contract.UserCenterContract
import com.example.center.contract.UserLoginContract
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.model.protocol.resp.RespUserEntity
import com.example.center.repoitory.UserCenterRepositoryImpl
import com.example.center.repoitory.UserLoginRepositoryImpl
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @Author : August
 * @Time : On 2021/7/30 13:47
 */
class UserLoginPresenterImpl(_view: UserLoginContract.UserCenterView) : UserLoginContract.UserLoginPresenter(_view) {
    override fun login(entitiy: UserEntitiy) {
        mRepository.login(entitiy)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<BaseRespEntity<RespUserEntity>>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: BaseRespEntity<RespUserEntity>) {
                    mView.get()!!.loginSuccess(t)
                }

                override fun onError(e: Throwable) {
                    mView.get()!!.loginFailed(e)
                }

            })
    }

    override fun createRepository(): UserLoginContract.UserCenterRepository {
        return UserLoginRepositoryImpl()
    }
}