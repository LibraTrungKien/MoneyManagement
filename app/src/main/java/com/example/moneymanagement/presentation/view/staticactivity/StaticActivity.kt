package com.example.moneymanagement.presentation.view.staticactivity

import com.example.moneymanagement.databinding.ActivityStaticBinding
import com.example.moneymanagement.presentation.view.adapter.StaticAdapter
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class StaticActivity : BaseActivity<ActivityStaticBinding> ((ActivityStaticBinding:: inflate)) {

    private lateinit var adapter : StaticAdapter

    override fun initializeComponent() {
        super.initializeComponent()

        adapter = StaticAdapter(this)
        binding.viewPageStatic.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPageStatic, ){ tab, position ->
            tab.text = when (position) {
                0 -> "Expend"
                1 -> "Income"
                2 -> "Loan"
                else -> "Expend"
            }
        }.attach()
    }

    override fun initializeEvents() {
        binding.btnBack.setOnClickListener { finish() }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

}