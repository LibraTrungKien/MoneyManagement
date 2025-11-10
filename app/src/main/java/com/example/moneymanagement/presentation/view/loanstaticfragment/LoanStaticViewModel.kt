package com.example.moneymanagement.presentation.view.loanstaticfragment

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.github.mikephil.charting.data.PieEntry

class LoanStaticViewModel : ViewModel() {
    private val _pieChartData = MutableLiveData<List<PieEntry>>()
    val pieChartData: LiveData<List<PieEntry>> get() = _pieChartData

    fun setAppDataBase(db : AppDatabase, owner : LifecycleOwner){

        db.expendDao().getAll().observe(owner){entities ->

            val groupIncome = entities.filter { it.type == "loan" }
            val totalIncome = groupIncome.sumOf { it.amountExpend }

            val group = groupIncome.groupBy { it.nameTypeCategory }
                .map{(nameCategory, money) ->
                    val totalMoneyTypeCategory = money.sumOf { it.amountExpend }
                    val per = (totalMoneyTypeCategory.toDouble() / totalIncome.toDouble()) * 100
                    PieEntry(per.toFloat(), nameCategory)
                }
            _pieChartData.postValue(group)
        }

    }
}