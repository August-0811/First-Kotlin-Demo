package com.example.mvpcore.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpcore.common.ConstValue

/**
 * @Author : August
 * @Time : On 2021/7/28 19:35
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initData(savedInstanceState)
        initEvent()

        if (isClearStatBar()){
            ClearStatBar()
        }
    }


    /**
     * 去掉状态栏
     */
    fun ClearStatBar(){

    }

    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(this@BaseActivity,otherActivity))
    }

    /**
     * 带参跳转
     */
    fun jumpActivity(otherActivity: Class<*>,params:Bundle?){
        val intent:Intent = Intent(this@BaseActivity,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }

    fun showMsg(msg:String){
        Toast.makeText(this@BaseActivity,msg,Toast.LENGTH_SHORT).show()
    }

    /**
     * 受否沉静
     */
    abstract fun isClearStatBar(): Boolean

    abstract fun initEvent()

    abstract fun initData(savedInstanceState:Bundle?)


    abstract fun getLayoutID(): Int

    /***
     * 释放资源
     */
    abstract fun releaseResurce()

    override fun onStop() {
        super.onStop()
    }


}