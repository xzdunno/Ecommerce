package com.example.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_screen.data.model.HomeStore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hotsales_row.view.*

class HotSaleAdapter (): RecyclerView.Adapter<CustomViewHolderHot>(){

    private var listData: List<HomeStore>? = null
    fun setListData(listData: List<HomeStore>?) {
        this.listData = listData
    }
    override fun getItemCount():Int{
        if (listData==null) return 0
        return listData?.size!!
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderHot {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hotsales_row,parent,false)
        return CustomViewHolderHot(view)
    }
    override fun onBindViewHolder(holder: CustomViewHolderHot, position: Int) {
        holder.bind(listData?.get(position)!!)
    }
}
class CustomViewHolderHot(var view: View): RecyclerView.ViewHolder(view){
    val img=view.hotImg
    val phone=view.phoneTxt
    val subTxt=view.subsTxt
    fun bind(hot: HomeStore){
phone.text=hot.title
subTxt.text=hot.subtitle
        Picasso.get().load(hot.picture).into(img)
    }
}