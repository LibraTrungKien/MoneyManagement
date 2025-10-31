package com.example.moneymanagement.presentation.view.homeactivity

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.core.view.GravityCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ActivityHomeBinding
import com.example.moneymanagement.presentation.view.adapter.HomeAdapter
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.example.moneymanagement.presentation.view.popup.SelectionYearPopup
import com.google.android.material.tabs.TabLayoutMediator


class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {

    private lateinit var adapter: HomeAdapter
    private var initMoneyVisible = true
    private var yearPopup: SelectionYearPopup? = null

    override fun initializeComponent() {

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

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
        binding.btnMonthSelection.setOnClickListener { showYearPopup() }
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

    private fun showYearPopup() {
        if (yearPopup == null) {
            yearPopup = SelectionYearPopup(this, this)
        }
        yearPopup?.showPopup(binding.btnMonthSelection)
    }

}