package com.example.center.model.service

import com.example.center.contract.FindListContract
import com.example.center.model.api.UserCenterApi
import com.example.center.util.Bean.FindEntity
import com.example.net.RetrofitFactory
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/8/2 16:09
 */
class FindListModelImpl : FindListContract.FindListModel {
    override fun findlist(keyword:String,type: String): Observable<FindEntity> {
        val create = RetrofitFactory.retrofitInstance.create(UserCenterApi::class.java)
        return create.find_goods(keyword,type)
    }
}