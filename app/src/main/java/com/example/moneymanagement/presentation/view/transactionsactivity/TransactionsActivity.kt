package com.example.moneymanagement.presentation.view.transactionsactivity

import android.util.Log
import com.example.moneymanagement.databinding.ActivityTransactionsBinding
import com.example.moneymanagement.presentation.Utils
import com.example.moneymanagement.presentation.database.AddNewEntity
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.gson.Gson
import kotlin.jvm.java

class TransactionsActivity : BaseActivity<ActivityTransactionsBinding>(ActivityTransactionsBinding::inflate) {

    private lateinit var data : TransactionChild

    override fun initializeComponent() {
        super.initializeComponent()

        val value = intent.getStringExtra(Utils.ITEM_HISTORY_EXPEND.name)
        val gson = Gson()
        data = gson.fromJson(value, TransactionChild::class.java)


    }

    override fun initializeEvents() {
        binding.btnBack.setOnClickListener { finish() }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        binding.imgCategoryMain.setImageResource(data.imgCategory)
        binding.txtNameTypeCategory.text = data.nameCategory
        binding.txtPrice.text = "- " + data.expendPrice.toString() + "vnđ"
        binding.txtdate.text = data.time
        binding.imgCategory.setImageResource(data.imgCategory)
        binding.txtNameCategory.text = data.nameCategory
        binding.txtContentCategory.text = data.note
        binding.txtNameBudget.text = data.nameBudget
        binding.txtContentBudget.text = data.note
        binding.edtNote.setText(data.note)

    }

}