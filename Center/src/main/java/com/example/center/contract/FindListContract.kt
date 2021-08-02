package com.example.center.contract

import com.example.center.util.Bean.FindEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/8/2 16:00
 */
interface FindListContract {

    interface FindListModel : IModel{
        fun findlist(keyword:String,type: String) : Observable<FindEntity>

    }

    interface FindListView : IVew{
        fun <T> findlistSuccess(data : T)

        fun findlstFaild(throwable: Throwable)
    }

    abstract class FindRepository : BaseRepository<FindListModel>(){
        abstract fun findlist(keyword:String,type: String) : Observable<FindEntity>
    }

    abstract class FindPresenter(view : FindListView) : BasePresenter<FindRepository,FindListView>(view){
        abstract fun  findlist(keyword:String,type: String)
    }

}