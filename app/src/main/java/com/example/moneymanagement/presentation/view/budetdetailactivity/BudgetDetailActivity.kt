package com.example.moneymanagement.presentation.view.budetdetailactivity

import android.widget.Toast
import com.example.moneymanagement.databinding.ActivityBudgetDetailBinding
import com.example.moneymanagement.presentation.view.adapter.OnAddBudgerListener
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.example.moneymanagement.presentation.view.dialog.SetBudgetNameBottomSheetDialog

class BudgetDetailActivity :
    BaseActivity<ActivityBudgetDetailBinding>(ActivityBudgetDetailBinding::inflate),
    OnAddBudgerListener {

    override fun initializeComponent() {
        super.initializeComponent()
    }

    override fun initializeEvents() {

        binding.btnBack.setOnClickListener { finish() }

        binding.btnAddBudget.setOnClickListener {
            val sheet = SetBudgetNameBottomSheetDialog()
            sheet.setListener(this)
            sheet.show(supportFragmentManager, "add budget")
        }

    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    override fun onAddBudgetListener(setMoney: Int, setNameBudget: String) {

    }

}