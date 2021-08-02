package com.example.center.firstfragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.center.R
import com.example.center.contract.FreshenContract
import com.example.center.model.protocol.resp.RespClassfigEntity
import com.example.center.presenter.FreshenPressenterImpl
import com.example.center.ui.FindActivity
import com.example.center.util.Ada.ClassfigAda
import com.example.center.util.Ada.GoodsListAda
import com.example.center.util.Bean.GoodsListEntity
import com.example.center.util.Ada.TabUtil
import com.example.mvpcore.view.BaseMVPFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_freshen.*
import java.util.*

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
        //加载商品列表
        fPersenter.goodslist()


        var tabEntitys:ArrayList<CustomTabEntity> = arrayListOf()

        tabEntitys.add(TabUtil("精选", 0, 0))
        tabEntitys.add(TabUtil("十一", 0, 0))
        tabEntitys.add(TabUtil("电器", 0, 0))
        tabEntitys.add(TabUtil("生活", 0, 0))



        goods_tab.setTabData(tabEntitys)


        /**
         * 添加搜索框跳转
         */
        goods_find.setOnClickListener {
            // MainActivity
            // A A从右边移动到最左边消失
            // B B从右边出现移动到最左边
            startActivity(Intent(activity,FindActivity::class.java))
            // 添加切换的动画
            activity!!.overridePendingTransition(R.anim.left_enter_anim,R.anim.left_exit_anim)

        }


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

    /**
     * 商品分类请求
     */

    override fun <T> classfigSuccess(data: T) {
//        showMsg("成功")
        var respgood: RespClassfigEntity = data as RespClassfigEntity
        var  data : List<RespClassfigEntity.Data>? = respgood.data

        classfig_rec.adapter = ClassfigAda(
            R.layout.classfig_layout,
            data as MutableList<RespClassfigEntity.Data>?
        )
        classfig_rec.layoutManager = GridLayoutManager(context,2,RecyclerView.HORIZONTAL,false)
        Log.i("Success","registerthrowable:${data.toString()}")
    }

    override fun classfigFaild(throwable: Throwable) {
        showMsg("失败")
        Log.i("Faild","registerthrowable:${throwable.message}")
    }

    /**
     * 商品列表请求
     */

    override fun <T> classlistSuccess(data: T) {
        Log.i("classlistSuccess","registerthrowable:${data.toString()}")
        val goodsListEntity = data as GoodsListEntity
        val data : List<GoodsListEntity.Data> = goodsListEntity.data

        goods_list.adapter = GoodsListAda(
            R.layout.goodslist_layout,
            data as MutableList<GoodsListEntity.Data>
        )
        goods_list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun classlistFaild(throwable: Throwable) {
        Log.i("classlistFaild","registerthrowable:${throwable.message}")
    }

}
