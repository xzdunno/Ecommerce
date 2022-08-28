package com.example.main_screen.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.ecommerce.BestSellAdapter
import com.example.ecommerce.HotSaleAdapter
import com.example.main_screen.R
import com.example.main_screen.data.model.Home
import com.example.main_screen.databinding.ActivityMainScreenBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response
import java.lang.IllegalArgumentException

class MainScreenFragment : Fragment() {
    lateinit var bind:ActivityMainScreenBinding
    private val mViewModel by viewModel<MainViewModel>()
    lateinit var recViewBest:BestSellAdapter
    lateinit var recViewHot: HotSaleAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= ActivityMainScreenBinding.inflate(layoutInflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

Log.d("mainAct","kldfjddj")
        BottomSheetBehavior.from(bottSheet).apply {
            peekHeight=0
            this.state= BottomSheetBehavior.STATE_COLLAPSED
        }

        bind.recViewBestSell.apply{
            layoutManager= GridLayoutManager(requireContext(),2)
            recViewBest= BestSellAdapter()
            adapter=recViewBest
        }

        bind.recViewHot.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            recViewHot = HotSaleAdapter()
            adapter =recViewHot
        }
        bind.recViewBestSell.setOnClickListener(){
            it.let {

            }
        }
        PagerSnapHelper().attachToRecyclerView(bind.recViewHot)
       mViewModel.getHomeData()
        mViewModel.myResponse?.observe(requireActivity(), Observer<Home> { response->
                recViewBest.setListData(response!!.best_seller!!)
                recViewBest.notifyDataSetChanged()
                recViewHot.setListData(response!!.home_store!!)
                recViewHot.notifyDataSetChanged()
            }
        )

        bind.filterOpt.setOnClickListener(){
            BottomSheetBehavior.from(bind.bottSheet).apply {
                this.state= BottomSheetBehavior.STATE_EXPANDED
            }
        }
        bind.closeFiltBtn.setOnClickListener(){
            BottomSheetBehavior.from(bind.bottSheet).apply {
                this.state= BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        val brandAdapter= ArrayAdapter(requireContext(), R.layout.filter_dropdown_text,resources.getStringArray(R.array.Brands))
        bind.brandAutoCompl.setAdapter(brandAdapter)
        val priceAdapter= ArrayAdapter(requireContext(),R.layout.filter_dropdown_text,resources.getStringArray(R.array.Price))
        bind.priceAutoCompl.setAdapter(priceAdapter)
        val inchAdapter= ArrayAdapter(requireContext(),R.layout.filter_dropdown_text,resources.getStringArray(R.array.Size))
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