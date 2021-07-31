package com.example.center.util

/**
 * @Author : August
 * @Time : On 2021/7/31 9:51
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

