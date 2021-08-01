package com.example.center.presenter

import com.example.center.contract.FreshenContract
import com.example.center.model.protocol.rep.ClassfigEntity
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.repoitory.FreshenRepositoryImpl
import com.example.center.util.GoodsListEntity
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @Author : August
 * @Time : On 2021/7/31 16:14
 */
class FreshenPressenterImpl (_view:FreshenContract.GoodsView) : FreshenContract.GoodCenterPresenter(_view){
    override fun classfig() {
        mRepository.classfig()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<RespClassfigEntity>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: RespClassfigEntity) {
                    mView.get()!!.classfigSuccess(t)
                }

                //返回错误信息
                override fun onError(e: Throwable) {
                    mView.get()!!.classfigFaild(e)
                }



            })
    }

    override fun goodslist() {
        mRepository.goodslist()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<GoodsListEntity>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: GoodsListEntity) {
                    mView.get()!!.classlistSuccess(t)
                }

                override fun onError(e: Throwable) {
                    mView.get()!!.classlistFaild(e)                }

            })
    }

    override fun createRepository(): FreshenContract.GoodsCenterRepository {
       return FreshenRepositoryImpl()
    }

}