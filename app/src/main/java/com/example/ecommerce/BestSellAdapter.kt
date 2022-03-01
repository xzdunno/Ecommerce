package com.example.ecommerce

import androidx.recyclerview.widget.RecyclerView
import java.util.*
import android.view.LayoutInflater
import android.graphics.Paint
import com.squareup.picasso.Picasso
import android.view.View
import com.example.ecommerce.model.BestSeller
import android.view.ViewGroup
import android.widget.CheckBox
import kotlinx.android.synthetic.main.bestseller_row.view.*
class BestSellAdapter(): RecyclerView.Adapter<CustomViewHolderBest>(){

    private var listData: List<BestSeller>? = null
    fun setListData(listData: List<BestSeller>?) {
        this.listData = listData
    }
    override fun getItemCount():Int{
        if (listData==null) return 0
        return listData?.size!!
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderBest {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.bestseller_row,parent,false)
        return CustomViewHolderBest(view)
    }
    override fun onBindViewHolder(holder: CustomViewHolderBest, position: Int) {
        /*holder.favCheck.setOnCheckedChangeListener(){it,isChecked->
            if (isChecked) it.setButtonDrawable(R.drawable.ic_heart_empty)
            else it.setButtonDrawable(R.drawable.ic_heart_full)
        }*/
/*holder.favCheck.setOnClickListener(){
    it as CheckBox
    if (!it.isChecked()){
        it.setButtonDrawable(R.drawable.ic_heart_full)
    }
    else it.setButtonDrawable(R.drawable.ic_heart_empty)
}*/
        holder.bind(listData?.get(position)!!)
    }
}
class CustomViewHolderBest(var view: View):RecyclerView.ViewHolder(view){
    val mainImg=view.mainImg
    val discTxt=view.discTxt
    val withoutDiscTxt=view.withoutDiscTxt
    val nameTxt=view.nameTxt
    val favCheck=view.recFavCheck
fun bind(best:BestSeller){
    if(best.price_without_discount>best.discount_price){
        discTxt.text="$"+best.discount_price.toString()
        withoutDiscTxt.text="$"+best.price_without_discount.toString()
    }
    else{
        withoutDiscTxt.text="$"+best.discount_price.toString()
        discTxt.text="$"+best.price_without_discount.toString()
    }

    withoutDiscTxt.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    nameTxt.text=best.title
    Picasso.get().load(best.picture).into(mainImg)
}
}