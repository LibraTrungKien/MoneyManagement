package com.example.moneymanagement.presentation.view.home

import androidx.core.view.GravityCompat
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ActivityHomeBinding
import com.example.moneymanagement.presentation.view.adapter.HomeAdapter
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator


class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {

    private lateinit var adapter: HomeAdapter
    private var initMoneyVisible = true

    override fun initializeComponent() {
        adapter = HomeAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Expend"
                1 -> "Income"
                2 -> "Loan"
                else -> "Expend"
            }
        }.attach()
    }

    override fun initializeEvents() {
        totalMoneyVisibility()
        menu()
    }


    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        bindMoneyVisibility()
    }

    private fun totalMoneyVisibility() {
        val sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE)
        initMoneyVisible = sharedPreferences.getBoolean("isMoneyVisible", true)

        binding.btnEyeTotalMoney.setOnClickListener {
            val isMoneyVisible = sharedPreferences.getBoolean("isMoneyVisible", true)

            val newVisibilityState = !isMoneyVisible

            if (newVisibilityState) {
                binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye)
                binding.txtTotalMoney.text = "$ 5,000,000"
            } else {
                binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye_remove_total_money)
                binding.txtTotalMoney.text = "*** *** ***"
            }

            sharedPreferences.edit()
                .putBoolean("isMoneyVisible", newVisibilityState)
                .apply()
        }
    }

    private fun menu() {
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun bindMoneyVisibility() {
        if (initMoneyVisible) {
            binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye)
            binding.txtTotalMoney.text = "$ 5,000,000"
        } else {
            binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye_remove_total_money)
            binding.txtTotalMoney.text = "*** *** ***"
        }
    }

}