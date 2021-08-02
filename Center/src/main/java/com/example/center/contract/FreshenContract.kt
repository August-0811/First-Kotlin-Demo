package com.example.center.contract

import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.util.Bean.GoodsListEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IVew
import io.reactivex.Observable

/**
 * @Author : August
 * @Time : On 2021/7/31 15:41
 */
interface FreshenContract {

        interface GoodsMdel : IModel{
            fun classfig () : Observable<RespClassfigEntity>
            fun goodslist() : Observable<GoodsListEntity>

        }

        interface GoodsView :IVew {
            fun <T> classfigSuccess (data:T)
            fun <T> classlistSuccess (data:T)


            fun classfigFaild (throwable: Throwable)
            fun classlistFaild (throwable: Throwable)


        }




    abstract class GoodsCenterRepository:BaseRepository<GoodsMdel>(){
        abstract fun classfig() : Observable<RespClassfigEntity>
        abstract fun goodslist() : Observable<GoodsListEntity>

    }


    abstract class GoodCenterPresenter(view : GoodsView) : BasePresenter<GoodsCenterRepository,GoodsView>(view){
        abstract fun classfig()
        abstract fun goodslist()
    }

}