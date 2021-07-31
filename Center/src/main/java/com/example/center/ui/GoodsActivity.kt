package com.example.center.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.example.center.R
import com.example.center.firstfragment.*
import com.example.center.util.FragAda
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_goods.*

class GoodsActivity : AppCompatActivity() {

    var tabEntitys:ArrayList<CustomTabEntity> = arrayListOf()
    var fragmentList:MutableList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)

        fragmentList.add(FreshenFragment())
        fragmentList.add(ClassflyFragment())
        fragmentList.add(FindFragment())
        fragmentList.add(ShoppingCatFragment())
        fragmentList.add(MyFragment())

        goods_vp.adapter = FragAda(supportFragmentManager,fragmentList)


        good_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                goods_vp.currentItem = position
            }

        })

        /**
         * 文字 背景 颜色
         */
        good_bar.setMode(BottomNavigationBar.MODE_FIXED)
            .setBarBackgroundColor("#ffffff")
            .setInActiveColor("#000000")
            .setActiveColor("#ff0000")
                var textcolor:TextBadgeItem = TextBadgeItem()
                        textcolor.setBackgroundColor(Color.RED).setText("14").setTextColor(Color.WHITE)
                            good_bar
                                .addItem(BottomNavigationItem(R.drawable.home1,"刷新"))
                                .addItem(BottomNavigationItem(R.drawable.find,"发现"))
                                .addItem(BottomNavigationItem(R.drawable.classfig,"分类"))
                                .addItem(BottomNavigationItem(R.drawable.cat,"购物车").setBadgeItem(textcolor))
                                .addItem(BottomNavigationItem(R.drawable.my,"我的"))

                            .initialise()




//        tabEntitys.add(TabUtil("刷新",R.drawable.home1,R.drawable.home2))
//        tabEntitys.add(TabUtil("分类",R.drawable.classfig,R.drawable.classfig1))
//        tabEntitys.add(TabUtil("发现",R.drawable.find,R.drawable.find1))
//        tabEntitys.add(TabUtil("购物",R.drawable.cat,R.drawable.cat1))
//        tabEntitys.add(TabUtil("我的",R.drawable.my,R.drawable.my2))
//
//        goods_tab.setTabData(tabEntitys)
//
//        goods_tab.setOnTabSelectListener(object : OnTabSelectListener{
//            override fun onTabSelect(position: Int) {
//                goods_vp.currentItem = position
//            }
//
//            override fun onTabReselect(position: Int) {
//
//            }
//
//        })
//


        goods_vp.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
//                goods_tab.currentTab = position
            }

        })


    }
}
