package com.example.moneymanagement.presentation.view.addnew

import android.util.Log
import com.example.moneymanagement.R
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.moneymanagement.databinding.ActivityAddNewBinding
import com.example.moneymanagement.presentation.dataexpend.DataManager
import com.example.moneymanagement.presentation.view.adapter.AddNewAdapter
import com.example.moneymanagement.presentation.view.addnewexpend.FragmentAddNewExpend
import com.example.moneymanagement.presentation.view.addnewincome.FragmentAddNewIncome
import com.example.moneymanagement.presentation.view.addnewloan.AddNewLoanFragment
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class AddNewActivity : BaseActivity<ActivityAddNewBinding>(ActivityAddNewBinding::inflate) {

    private lateinit var adapter: AddNewAdapter
    private val addNewViewModel: AddNewViewModel by viewModels()
    private lateinit var typeAddNew: String

    override fun initializeComponent() {
        super.initializeComponent()

        adapter = AddNewAdapter(this)
        binding.viewPagerAddNew.adapter = adapter

        val appDatabase = DataManager.getDataBase(this)
        addNewViewModel.setAppDataBase(appDatabase)

        TabLayoutMediator(binding.tabLayoutAdd, binding.viewPagerAddNew) { tab, position ->
            tab.text = when (position) {
                0 -> "Expend"
                1 -> "Income"
                2 -> "Loan"
                else -> "Expend"
            }
        }.attach()

        binding.viewPagerAddNew.registerOnPageChangeCallback(object :
            androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                typeAddNew = when (position) {
                    0 -> "expend"
                    1 -> "income"
                    2 -> "loan"
                    else -> "expend"
                }
                addNewViewModel.setType(typeAddNew)
            }
            })

    }

    override fun initializeEvents() {
        binding.btnCancel.setOnClickListener { finish() }
        binding.btnSave.setOnClickListener { saveData() }
    }

    private fun saveData() {

        val getCurrent = binding.viewPagerAddNew.currentItem

        when(getCurrent){
            0 -> {
                val fragmentExpend = supportFragmentManager.findFragmentByTag("f0") as? FragmentAddNewExpend
                fragmentExpend?.sendDataExpend()
            }

            1 -> {
                val fragmentIncome = supportFragmentManager.findFragmentByTag("f1") as? FragmentAddNewIncome
                fragmentIncome?.sendDataIncome()
            }

            2 -> {
                val fragmentLoan = supportFragmentManager.findFragmentByTag("f2") as? AddNewLoanFragment
                fragmentLoan?.senDataLoan()
            }
        }

        val data = addNewViewModel.getDataList()
        if (!data.isNullOrEmpty()) {
            val expend = data[0]
            addNewViewModel.insertExpendEntity(
                expend.amountExpend,
                expend.type,
                expend.nameTypeCategory,
                expend.imgTypeCategory,
                expend.nameBudget,
                expend.note,
                expend.dateExpend,
                expend.timeExpend

            )
            Toast.makeText(this, "Save success", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}