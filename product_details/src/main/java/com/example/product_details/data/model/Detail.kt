package com.example.product_details.data.model

data class Detail(
    val id:Int,
    val CPU:String,
    val camera:String,
    val isFavorites:String,
    val price: Int,
    val rating:Int,
    val sd:String,
    val ssd:String,
    val title:String,
    val images:List<String>,
    val color:List<String>,
    val capacity:List<Int>
)