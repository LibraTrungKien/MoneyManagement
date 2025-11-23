package com.example.moneymanagement.presentation.view.budgetactivity

import android.content.Intent
import android.widget.Toast
import com.example.moneymanagement.databinding.ActivityBudgetBinding
import com.example.moneymanagement.presentation.view.adapter.OnBudgetUpdatedListener
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.example.moneymanagement.presentation.view.budetdetailactivity.BudgetDetailActivity
import com.example.moneymanagement.presentation.view.dialog.SetMoneyBudgetBottomSheet

class BudgetActivity : BaseActivity<ActivityBudgetBinding>
    (ActivityBudgetBinding::inflate),
    OnBudgetUpdatedListener {

    override fun initializeComponent() {
        super.initializeComponent()
    }

    override fun initializeEvents() {
        binding.btnBack.setOnClickListener { finish() }

        binding.btnEditMoneyBudget.setOnClickListener {
            val sheet = SetMoneyBudgetBottomSheet()
            sheet.setListener(this)
            sheet.show(supportFragmentManager, "money")
        }

        binding.btnBudgetDetail.setOnClickListener {
            val intent = Intent(this, BudgetDetailActivity::class.java)
            startActivity(intent)
        }

    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    override fun onMoneySet(amount: Int) {
        binding.txtMoneyBudget.text = "$amount đ"
    }

}