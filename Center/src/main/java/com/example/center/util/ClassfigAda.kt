package com.example.center.util

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.center.R
import com.example.center.model.protocol.resp.RespClassfigEntity

/**
 * @Author : August
 * @Time : On 2021/7/31 16:49
 */
class ClassfigAda(layoutResId: Int, data: MutableList<RespClassfigEntity.Data>?) :
    BaseQuickAdapter<RespClassfigEntity.Data, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: RespClassfigEntity.Data?) {
        helper!!.setText(R.id.classfig_text,item!!.category_name)
        Glide.with(mContext).load(R.drawable.yuan).into(helper.getView(R.id.classfig_image))
    }


}