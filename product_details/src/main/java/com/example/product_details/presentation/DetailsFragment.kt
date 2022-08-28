package com.example.product_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.product_details.databinding.DetailFragmentBinding

class DetailsFragment:Fragment() {
    private lateinit var binding:DetailFragmentBinding
   // private val viewModel by viewModel<DetailsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding=DetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}