package com.example.moneymanagement.presentation.view.homeactivity

import android.content.Intent
import androidx.core.view.GravityCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ActivityHomeBinding
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.view.adapter.HomeAdapter
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.example.moneymanagement.presentation.view.budgetactivity.BudgetActivity
import com.example.moneymanagement.presentation.view.popup.SelectionYearPopup
import com.example.moneymanagement.presentation.view.staticactivity.StaticActivity
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
        setupNavigationViewListener()
    }


    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
    }

    private fun totalMoneyVisibility() {
        val sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE)
        initMoneyVisible = sharedPreferences.getBoolean("isMoneyVisible", true)

        val money = 0
        var totalMoney = 0

        val db = DataManager.getDataBase(this)
        db.expendDao().getAll().observe(this) { list ->

            val expendMoney = list.filter { it.type == "expend" }
            val totalMoneyExpend = expendMoney.sumOf { it.amountExpend }

            val incomeMoney = list.filter { it.type == "income" }
            val totalMoneyIncome = incomeMoney.sumOf { it.amountExpend }

            totalMoney = money - totalMoneyExpend + totalMoneyIncome

            if (initMoneyVisible) {
                binding.txtTotalMoney.text = " $totalMoney vnđ"
            } else {
                binding.txtTotalMoney.text = "*** *** ***"
            }
        }

        binding.btnEyeTotalMoney.setOnClickListener {
            val isMoneyVisible = sharedPreferences.getBoolean("isMoneyVisible", true)
            val newVisibilityState = !isMoneyVisible

            if (newVisibilityState) {
                binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye)
                binding.txtTotalMoney.text = " $totalMoney vnđ"
            } else {
                binding.btnEyeTotalMoney.setBackgroundResource(R.drawable.ic_eye_remove_total_money)
                binding.txtTotalMoney.text = "*** *** ***"
            }

            sharedPreferences.edit()
                .putBoolean("isMoneyVisible", newVisibilityState)
                .apply()

            initMoneyVisible = newVisibilityState
        }
    }

    private fun menu() {
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }


    private fun showYearPopup() {
        if (yearPopup == null) {
            yearPopup = SelectionYearPopup(this, this)
        }
        yearPopup?.showPopup(binding.btnMonthSelection)
    }


    private fun setupNavigationViewListener() {
        binding.navMenu.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            when (it.itemId) {

                R.id.statistics -> {
                    val intent = Intent(this, StaticActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_budget -> {
                   val intent = Intent(this, BudgetActivity::class.java )
                    startActivity(intent)
                    true
                }

                R.id.nav_currency -> {
                    // TODO: Mở tùy chọn tiền tệ
                    true
                }

                R.id.nav_language -> {
                    // TODO: Mở tùy chọn ngôn ngữ
                    true
                }

                else -> false
            }

        }
    }

}