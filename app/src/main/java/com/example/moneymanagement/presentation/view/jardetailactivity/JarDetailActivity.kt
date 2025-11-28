package com.example.moneymanagement.presentation.view.jardetailactivity

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.ActivityJarDetailBinding
import com.example.moneymanagement.presentation.Utils
import com.example.moneymanagement.presentation.database.BudgetEntity
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.gson.Gson

class JarDetailActivity :
    BaseActivity<ActivityJarDetailBinding>(ActivityJarDetailBinding::inflate) {

    private lateinit var budgetEntity: BudgetEntity
    private lateinit var viewModel: JarDetailViewModel

    override fun initializeComponent() {

        viewModel = ViewModelProvider(this)[JarDetailViewModel::class.java]
        val appDatabase = DataManager.getDataBase(this)
        viewModel.setAppDataBase(appDatabase)

        val data = intent.getStringExtra(Utils.BUDGET_DETAIL.name)
        val gson = Gson()
        budgetEntity = gson.fromJson(data, BudgetEntity::class.java)


    }

    override fun initializeEvents() {
        binding.btnExit.setOnClickListener { finish() }

        binding.btnDelete.setOnClickListener { deleteBudget() }

    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        binding.txtTitleJar.text = budgetEntity.nameBudget
        binding.totalMoneyJar.text = budgetEntity.moneyBudget.toString()
    }

    private fun deleteBudget() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Delete Budget")
            .setMessage("Do you want to delete budget")
            .setPositiveButton("Delete") { _ , _ ->
                viewModel.deleteBudget(budgetEntity)

                finish()
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }



}