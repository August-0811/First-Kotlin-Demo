package com.example.mvpcore

/**
 * @Author : August
 * @Time : On 2021/7/28 19:21
 */
abstract class BaseRepository <M:IModel>{

    protected lateinit var mModel:M

    init {
        mModel = createModel()
    }

    abstract fun createModel(): M



}