package com.example.moneymanagement.presentation.view.incomestaticfragment

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry
import kotlin.collections.component1
import kotlin.collections.component2

class IncomeStaticViewModel : ViewModel() {
    private val _pieChartData = MutableLiveData<List<PieEntry>>()
    val pieChartData: LiveData<List<PieEntry>> get() = _pieChartData

    private val _barChart = MutableLiveData<List<BarEntry>>()
    val barChar: LiveData<List<BarEntry>> get() = _barChart

    private lateinit var db: AppDatabase

    fun setAppDataBase(db: AppDatabase) {
        this.db = db
    }

    fun getDataPieChart(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "income" }
            val total = groupType.sumOf { it.amountExpend }

            val group = groupType.groupBy { it.nameTypeCategory }
                .map { (nameTypeCategory, money) ->
                    val totalMoney = money.sumOf { it.amountExpend }
                    val per = (totalMoney.toDouble() / total.toDouble()) * 100

                    PieEntry(per.toFloat(), nameTypeCategory)
                }
            _pieChartData.postValue(group)
        }

    }

    fun getDataBarChart(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "income" }
            val grouped = groupType.groupBy { it.nameTypeCategory }

            val barEntries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            grouped.entries.forEachIndexed { index, entry ->
                val totalMoney = entry.value.sumOf { it.amountExpend }
                barEntries.add(BarEntry(index.toFloat(), totalMoney.toFloat()))
                labels.add(entry.key)
            }
            _barChart.postValue(barEntries)
        }
    }
}