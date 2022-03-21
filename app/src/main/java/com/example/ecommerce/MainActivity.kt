package com.example.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import com.example.ecommerce.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.databinding.ActivityMainBinding
import androidx.lifecycle.Observer
import com.example.main_screen.data.model.BestSeller
import com.example.main_screen.data.model.Home
import retrofit2.Response
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var bind:ActivityMainBinding
    lateinit var mViewModel:MainViewModel
    lateinit var recViewBest:BestSellAdapter
    lateinit var recViewHot: HotSaleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

BottomSheetBehavior.from(bottSheet).apply {
    peekHeight=0
    this.state=BottomSheetBehavior.STATE_COLLAPSED
}
        bind.recViewBestSell.apply{
layoutManager=GridLayoutManager(this@MainActivity,2)
            recViewBest=BestSellAdapter()
    adapter=recViewBest
}
        bind.recViewHot.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.HORIZONTAL,false)
            recViewHot = HotSaleAdapter()
            adapter =recViewHot
        }
        PagerSnapHelper().attachToRecyclerView(bind.recViewHot)
        mViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.getHomeData()
        mViewModel.myResponse.observe(this@MainActivity, Observer<Response<List<Home>>> {response->
            if(response.isSuccessful){
                recViewBest.setListData(response.body()!![0].best_seller!!)
                recViewBest.notifyDataSetChanged()
                recViewHot.setListData(response.body()!![0].home_store!!)
                recViewHot.notifyDataSetChanged()
            }
            else{}
        })
bind.filterOpt.setOnClickListener(){
    BottomSheetBehavior.from(bind.bottSheet).apply {
        this.state=BottomSheetBehavior.STATE_EXPANDED
    }
}
        bind.closeFiltBtn.setOnClickListener(){
            BottomSheetBehavior.from(bind.bottSheet).apply {
                this.state=BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        val brandAdapter=ArrayAdapter(this,R.layout.filter_dropdown_text,resources.getStringArray(R.array.Brands))
        bind.brandAutoCompl.setAdapter(brandAdapter)
        val priceAdapter=ArrayAdapter(this,R.layout.filter_dropdown_text,resources.getStringArray(R.array.Price))
        bind.priceAutoCompl.setAdapter(priceAdapter)
        val inchAdapter=ArrayAdapter(this,R.layout.filter_dropdown_text,resources.getStringArray(R.array.Size))
        bind.inchAutoCompl.setAdapter(inchAdapter)

        bind.phonesBtn.setOnClickListener(){
            it.setBackground(resources.getDrawable(R.drawable.categ_button_orange))
            bind.compBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.healthBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.booksBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
        }
        bind.compBtn.setOnClickListener(){
            it.setBackground(resources.getDrawable(R.drawable.categ_button_orange))
            bind.phonesBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.healthBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.booksBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
        }
        bind.healthBtn.setOnClickListener(){
            it.setBackground(resources.getDrawable(R.drawable.categ_button_orange))
            bind.compBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.phonesBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.booksBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
        }
        bind.booksBtn.setOnClickListener(){
            it.setBackground(resources.getDrawable(R.drawable.categ_button_orange))
            bind.compBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.healthBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
            bind.phonesBtn.setBackground(resources.getDrawable(R.drawable.categ_button))
        }
    }

}
