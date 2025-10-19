package com.example.moneymanagement.presentation.view.addnew

import com.example.moneymanagement.databinding.ActivityAddNewBinding
import com.example.moneymanagement.presentation.view.adapter.AddNewAdapter
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class AddNewActivity : BaseActivity<ActivityAddNewBinding>(ActivityAddNewBinding::inflate) {

    private lateinit var adapter: AddNewAdapter

    override fun initializeComponent() {
        super.initializeComponent()

        adapter = AddNewAdapter(this)
        binding.viewPagerAddNew.adapter = adapter

        TabLayoutMediator(binding.tabLayoutAdd, binding.viewPagerAddNew){tab, position ->
            tab.text = when(position){
                1 -> "Expend"
                2 -> "Income"
                3 -> "Loan"
                else -> "Expend"
            }
        }.attach()

    }


}