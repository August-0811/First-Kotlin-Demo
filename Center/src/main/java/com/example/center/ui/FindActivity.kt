package com.example.center.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.center.R
import com.example.center.contract.FindListContract
import com.example.center.presenter.FindListPresenter
import com.example.center.util.Ada.FindGoodsAda
import com.example.center.util.Bean.FindEntity
import com.example.mvpcore.view.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_find.*
import kotlinx.android.synthetic.main.fragment_freshen.*

class FindActivity : BaseMVPActivity<FindListPresenter>(),FindListContract.FindListView{

    lateinit var text:String

    override fun createPresenter(): FindListPresenter {
        return FindListPresenter(this)
    }

    override fun isClearStatBar(): Boolean {
        return true
    }

    override fun initEvent() {



        find.setOnClickListener {

            searchrecords.isVisible = false
            find_list.isVisible = true

             text = goodsfind.text.toString()
             mPresenter.findlist(text,text)

        }


//        goodsfind.addTextChangedListener(object : TextWatcher{
//            override fun afterTextChanged(s: Editable?) {
//                searchrecords.isVisible  = false
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getLayoutID(): Int {
       return R.layout.activity_find
        find_list.isVisible = false
    }

    override fun releaseResurce() {

    }

    override fun <T> findlistSuccess(data: T) {
        Log.i("findlist","registerSuccss:${data.toString()}")
        val findEntity = data as FindEntity
        val data:List<FindEntity.Data> = findEntity.data
        val findGoodsAda = FindGoodsAda(R.layout.find_layout, data as MutableList<FindEntity.Data>)

        find_list.adapter = findGoodsAda
        find_list.layoutManager = LinearLayoutManager(this)
        findGoodsAda.notifyDataSetChanged()

        

    }

    override fun findlstFaild(throwable: Throwable) {
        Log.i("findlist","registerthrowable:${throwable.message}")
    }

}
