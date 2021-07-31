package com.example.mvpcore.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvpcore.common.ConstValue

/**
 * @Author : August
 * @Time : On 2021/7/30 19:31
 */
abstract class BaseFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(getLayoutId(),container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData(savedInstanceState)
        initEvent()

        /**
         * 判断是否有状态栏
         */
        if(isClearStatBar()){
            ClearStatBar()
        }
    }

    /**
     * 跳转到另一个Activity
     */
    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(context,otherActivity))
    }

    /**
     * 带参数跳转
     */
    fun jumpActivity(otherActivity:Class<*>,params:Bundle?){
        val intent: Intent = Intent(context,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }

    /**
     * 显示消息
     */
    fun showMsg(msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?)

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 去掉状态栏 实现沉浸式
     */
    abstract fun ClearStatBar()

    /**
     * 是否实现沉浸式
     */
    protected open fun isClearStatBar(): Boolean{
        return true
    }

    override fun onStop() {
        super.onStop()
        releaseResource()
    }
    /**
     * 释放资源
     */
    abstract fun releaseResource()
}