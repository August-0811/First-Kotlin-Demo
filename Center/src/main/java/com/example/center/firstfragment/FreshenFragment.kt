package com.example.center.firstfragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.center.R
import com.example.center.contract.FreshenContract
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.presenter.FreshenPressenterImpl
import com.example.center.util.ClassfigAda
import com.example.center.util.TabUtil
import com.example.mvpcore.view.BaseMVPFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_freshen.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FreshenFragment : BaseMVPFragment<FreshenPressenterImpl>(),FreshenContract.GoodsView{

    override fun initEvent() {

        val arrayImageUrl = arrayListOf<String>("https://img0.baidu.com/it/u=3336798663,2109124309&fm=26&fmt=auto&gp=0.jpg",
            "https://img.alicdn.com/i4/1607053004/TB2BhRGocj_B1NjSZFHXXaDWpXa_!!1607053004.jpg",
            "https://img.alicdn.com/i2/1607053004/TB2edF1oljTBKNjSZFNXXasFXXa_!!1607053004.jpg")
        //设置样式
        goods_ban.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        //设置图片结合
        goods_ban.setImages(arrayImageUrl)
        goods_ban.setImageLoader(MyLoader())
        goods_ban.isAutoPlay(true)
        goods_ban.start()

        //加载分类
        fPersenter.classfig()
        var tabEntitys:ArrayList<CustomTabEntity> = arrayListOf()

        tabEntitys.add(TabUtil("精选",0,0))
        tabEntitys.add(TabUtil("十一",0,0))
        tabEntitys.add(TabUtil("电器",0,0))
        tabEntitys.add(TabUtil("生活",0,0))



        goods_tab.setTabData(tabEntitys)

    }


    //图片加载
    private inner class MyLoader :ImageLoader(){
        override fun displayImage(context: Context, path: Any, imageView: ImageView) {
            Glide.with(context).load(path as String).into(imageView)
        }

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_freshen
    }

    override fun ClearStatBar() {

    }

    override fun releaseResource() {

    }

    override fun createPresenter(): FreshenPressenterImpl {
        return FreshenPressenterImpl(this)
    }

    override fun <T> classfigSuccess(data: T) {
//        showMsg("成功")
        var respgood: RespClassfigEntity = data as RespClassfigEntity
        var  data : List<RespClassfigEntity.Data>? = respgood.data

        classfig_rec.adapter = ClassfigAda(R.layout.classfig_layout,data as MutableList<RespClassfigEntity.Data>?)
        classfig_rec.layoutManager = GridLayoutManager(context,2,RecyclerView.HORIZONTAL,false)


        Log.i("Success","registerthrowable:${data.toString()}")


    }

    override fun classfigFaild(throwable: Throwable) {
        showMsg("失败")
        Log.i("Faild","registerthrowable:${throwable.message}")
    }

}
