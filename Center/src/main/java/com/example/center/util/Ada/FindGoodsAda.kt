package com.example.center.util.Ada

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.center.R
import com.example.center.util.Bean.FindEntity
import kotlinx.android.synthetic.main.find_layout.view.*

/**
 * @Author : August
 * @Time : On 2021/8/2 16:29
 */
class FindGoodsAda(layoutResId: Int, data: MutableList<FindEntity.Data>?) :
    BaseQuickAdapter<FindEntity.Data, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: FindEntity.Data?) {
        helper!!.setText(R.id.find_money,item!!.ZkFinalPrice)
        helper!!.setText(R.id.find_name,item!!.Title)
        Glide.with(mContext).load(item.PictUrl).into(helper.getView(R.id.find_img))
    }
}