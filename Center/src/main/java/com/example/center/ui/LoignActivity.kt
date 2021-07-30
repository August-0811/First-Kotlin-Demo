package com.example.center.ui

import android.os.Bundle
import android.util.Log
import com.example.center.R
import com.example.center.contract.UserLoginContract
import com.example.center.model.protocol.rep.UserEntitiy
import com.example.center.presenter.UserLoginPresenterImpl
import com.example.mvpcore.view.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoignActivity : BaseMVPActivity<UserLoginPresenterImpl>(),UserLoginContract.UserCenterView {

    override fun createPresenter(): UserLoginPresenterImpl {
       return UserLoginPresenterImpl(this)
    }

    override fun isClearStatBar(): Boolean {
        return true
    }

    override fun initEvent() {
        btn_login.setOnClickListener {
            val phoneNumber:String = et_login_phonenumber.text.trim().toString()
            val pwd:String = et_login_pwd.text.trim().toString()

            mPresenter.login(UserEntitiy("2021-01-01",0,pwd,"1",phoneNumber))
        }

        go_register.setOnClickListener {
            jumpActivity(RegisterActivity::class.java)
        }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun releaseResurce() {
        TODO("Not yet implemented")
    }

    override fun <T> loginSuccess(data: T) {
        showMsg("登录成功")
        jumpActivity(GoodsActivity::class.java)
        Log.i("123","registerSuccss:${data.toString()}")
    }

    override fun loginFailed(throwable: Throwable) {
        showMsg("登录失败")
        Log.i("123","registerthrowable:${throwable.message}")
    }


}
