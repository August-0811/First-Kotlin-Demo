package com.example.center.contract

import com.example.center.model.protocol.rep.ClassfigEntity
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew
import com.example.net.protocol.resp.BaseRespEntity
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/31 15:41
 */
interface FreshenContract {
        interface GoodsMdel : IModel{
            fun classfig () : Observable<RespClassfigEntity>
        }

        interface GoodsView :IVew {
            fun <T> classfigSuccess (data:T)

            fun classfigFaild (throwable: Throwable)
        }


    abstract class GoodsCenterRepository:BaseRepository<GoodsMdel>(){
        abstract fun classfig() : Observable<RespClassfigEntity>
    }


    abstract class GoodCenterPresenter(view : GoodsView) : BasePresenter<GoodsCenterRepository,GoodsView>(view){
        abstract fun classfig()
    }

}