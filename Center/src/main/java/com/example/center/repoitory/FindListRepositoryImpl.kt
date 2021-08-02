package com.example.center.repoitory

import com.example.center.contract.FindListContract
import com.example.center.model.service.FindListModelImpl
import com.example.center.util.Bean.FindEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/8/2 16:18
 */
class FindListRepositoryImpl : FindListContract.FindRepository() {
    override fun findlist(keyword:String,type: String): Observable<FindEntity> {
        return mModel.findlist(keyword,type)
    }

    override fun createModel(): FindListContract.FindListModel {
        return FindListModelImpl()
    }
}