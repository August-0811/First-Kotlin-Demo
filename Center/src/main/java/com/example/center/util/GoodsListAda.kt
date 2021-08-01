package com.example.center.util

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.center.R
import kotlinx.android.synthetic.main.goodslist_layout.view.*

/**
 * @Author : August
 * @Time : On 2021/8/1 15:35
 */
class GoodsListAda(layoutResId: Int, data: MutableList<GoodsListEntity.Data>?) :
    BaseQuickAdapter<GoodsListEntity.Data, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: GoodsListEntity.Data?) {
        helper!!.setText(R.id.goodslist_text,item!!.Title)
        Glide.with(mContext).load(item.PictUrl).into(helper.getView(R.id.goodslist_img))
    }
}