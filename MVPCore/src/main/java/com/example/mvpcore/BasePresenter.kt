package com.example.mvpcore

import java.lang.ref.SoftReference

/**
 * @Author : August
 * @Time : On 2021/7/28 19:25
 */
abstract class BasePresenter<Repo:BaseRepository<*>,V:IVew>(_view:V){
    protected lateinit var mRepository:Repo
    protected lateinit var mView:SoftReference<V>
    init {
        mRepository = createRepository()
        mView = SoftReference<V>(_view)
    }

    abstract fun createRepository(): Repo

}