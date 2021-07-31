package com.example.center.model.protocol.rep

/**
 * @Author : August
 * @Time : On 2021/7/31 15:42
 */
data class ClassfigEntity(
    val code: Int,
    val `data`: List<Data>,
    val msg: String
){
    data class Data(
        val category_id: Int,
        val category_name: String,
        val id: Int,
        val parent_id: Int
    )
}

