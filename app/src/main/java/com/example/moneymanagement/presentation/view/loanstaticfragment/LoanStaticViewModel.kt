package com.example.moneymanagement.presentation.view.loanstaticfragment

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry

class LoanStaticViewModel : ViewModel() {
    private val _pieChartData = MutableLiveData<List<PieEntry>>()
    val pieChartData: LiveData<List<PieEntry>> get() = _pieChartData

    private val _barChartData = MutableLiveData<List<BarEntry>>()
    val barChar : LiveData<List<BarEntry>> get() = _barChartData

    private lateinit var db : AppDatabase

    fun setAppDataBase(db: AppDatabase){
        this.db = db
    }

    fun setDataPieChart(owner : LifecycleOwner){

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

    fun getDataBarChart(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "loan" }
            val grouped = groupType.groupBy { it.nameTypeCategory }

            val barEntries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            grouped.entries.forEachIndexed { index, entry ->
                val totalMoney = entry.value.sumOf { it.amountExpend }
                barEntries.add(BarEntry(index.toFloat(), totalMoney.toFloat()))
                labels.add(entry.key)
            }
            _barChartData.postValue(barEntries)
        }
    }


}