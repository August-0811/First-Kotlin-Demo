package com.example.center.repoitory

import com.example.center.contract.FreshenContract
import com.example.center.model.protocol.rep.ClassfigEntity
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.model.service.FreshenModelImpl
import com.example.center.util.GoodsListEntity
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/31 16:21
 */
class FreshenRepositoryImpl : FreshenContract.GoodsCenterRepository() {
    override fun classfig(): Observable<RespClassfigEntity> {
        return mModel.classfig()
    }

    override fun goodslist(): Observable<GoodsListEntity> {
        return mModel.goodslist()
    }


    override fun createModel(): FreshenContract.GoodsMdel {
        return FreshenModelImpl()
    }
}