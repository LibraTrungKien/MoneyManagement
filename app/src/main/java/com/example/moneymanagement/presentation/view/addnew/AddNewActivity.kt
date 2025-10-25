package com.example.moneymanagement.presentation.view.addnew

import android.widget.Toast
import androidx.activity.viewModels
import com.example.moneymanagement.databinding.ActivityAddNewBinding
import com.example.moneymanagement.presentation.dataexpend.DataManager
import com.example.moneymanagement.presentation.view.adapter.AddNewAdapter
import com.example.moneymanagement.presentation.view.addnewexpend.FragmentAddNewExpend
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class AddNewActivity : BaseActivity<ActivityAddNewBinding>(ActivityAddNewBinding::inflate) {

    private lateinit var adapter: AddNewAdapter
    private val addNewViewModel: AddNewViewModel by viewModels()

    override fun initializeComponent() {
        super.initializeComponent()

        adapter = AddNewAdapter(this)
        binding.viewPagerAddNew.adapter = adapter

        val appDatabase = DataManager.getDataBase(this)
        addNewViewModel.setAppDataBase(appDatabase)

        TabLayoutMediator(binding.tabLayoutAdd, binding.viewPagerAddNew) { tab, position ->
            tab.text = when (position) {
                1 -> "Expend"
                2 -> "Income"
                3 -> "Loan"
                else -> "Expend"
            }
        }.attach()

    }

    override fun initializeEvents() {
        binding.btnCancel.setOnClickListener { finish() }
        binding.btnSave.setOnClickListener { saveData() }
    }

    private fun saveData() {

        val fragment = supportFragmentManager.findFragmentByTag("f0") as? FragmentAddNewExpend
        fragment?.sendData()

        val data = addNewViewModel.getDataList()
        if (!data.isNullOrEmpty()) {
            val expend = data[0]
            addNewViewModel.insertExpendEntity(
                expend.amountExpend,
                expend.nameTypeCategory,
                expend.imgTypeCategory,
                expend.nameBudget,
                expend.imgBudget,
                expend.note ,
                expend.dateExpend,
                expend.timeExpend
            )
            Toast.makeText(this, "Save success", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Save fail", Toast.LENGTH_SHORT).show()
        }
        finish()

    }


}