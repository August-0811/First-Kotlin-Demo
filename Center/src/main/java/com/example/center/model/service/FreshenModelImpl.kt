package com.example.center.model.service

import com.example.center.contract.FreshenContract
import com.example.center.model.api.UserCenterApi
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.util.Bean.GoodsListEntity
import com.example.net.RetrofitFactory
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/31 16:06
 */
class FreshenModelImpl : FreshenContract.GoodsMdel {

    override fun classfig(): Observable<RespClassfigEntity> {
        var service = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return service.calssfig()

    }

    override fun goodslist(): Observable<GoodsListEntity> {
        var goodslist  = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return goodslist.gooslist()
    }
}