package com.example.center.ui

import android.os.Bundle
import com.example.center.MainActivity
import com.example.center.R
import com.example.center.contract.UserCenterContract
import com.example.center.presenter.UserCenterPresenterImpl
import com.example.mvpcore.view.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMVPActivity<UserCenterPresenterImpl>(),UserCenterContract.UserCenterView {

    override fun <T> registerSuccess(data: T) {
        showMsg("登录成功")
        jumpActivity(MainActivity::class.java)

    }

    override fun registerFailed(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun createPresenter(): UserCenterPresenterImpl {
        return UserCenterPresenterImpl(this)
    }

    override fun isClearStatBar(): Boolean {
       return true
    }

    override fun initEvent() {
        btn_register.setOnClickListener {
            val phoneNumber:String = et_register_phonenumber.text.trim().toString()
            val pwd:String = et_register_pwd.text.trim().toString()

            mPresenter.register(phoneNumber,pwd)
        }
    }

    override fun initData(savedInstanceState:Bundle?) {

    }


    override fun getLayoutID(): Int {
        return R.layout.activity_register
    }

    /**
     *  调用OnStop调用所有可以释放资源 移除Handler 停止动画
     */
    override fun releaseResurce() {

    }



}
