package com.example.center.model.service

import com.example.center.contract.FreshenContract
import com.example.center.model.api.UserCenterApi
import com.example.center.model.protocol.rep.ClassfigEntity
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.net.RetrofitFactory
import com.example.net.protocol.resp.BaseRespEntity
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
}