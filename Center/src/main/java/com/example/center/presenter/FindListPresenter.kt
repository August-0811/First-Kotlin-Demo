package com.example.center.presenter

import com.example.center.contract.FindListContract
import com.example.center.repoitory.FindListRepositoryImpl
import com.example.center.util.Bean.FindEntity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @Author : August
 * @Time : On 2021/8/2 16:14
 */
class FindListPresenter (_view : FindListContract.FindListView) : FindListContract.FindPresenter(_view){
    override fun findlist(keyword:String,type: String) {
        mRepository.findlist(keyword,type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<FindEntity>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: FindEntity) {
                    mView.get()!!.findlistSuccess(t)
                }

                override fun onError(e: Throwable) {
                   mView.get()!!.findlstFaild(e)
                }

            })
    }

    override fun createRepository(): FindListContract.FindRepository {
        return FindListRepositoryImpl()
    }
}