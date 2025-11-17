package com.example.moneymanagement.presentation.view.expendstaticfragment

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AddNewEntity
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.model.StaticCategoryChildModel
import com.example.moneymanagement.presentation.model.StaticCategoryParentModel
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExpendStaticViewModel : ViewModel() {

    private val _pieChartData = MutableLiveData<List<PieEntry>>()
    val pieChartData: LiveData<List<PieEntry>> get() = _pieChartData

    private val _barChart = MutableLiveData<List<BarEntry>>()
    val barChar: LiveData<List<BarEntry>> get() = _barChart

    private lateinit var db: AppDatabase

    private val _dataStatic = MutableLiveData<List<StaticCategoryParentModel>>()
    val dataStatic: LiveData<List<StaticCategoryParentModel>> get() = _dataStatic

    fun setAppDataBase(db: AppDatabase) {
        this.db = db
    }

    fun getDataPieChart(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "expend" }
            val total = groupType.sumOf { it.amountExpend }

            val group = groupType.groupBy { it.nameTypeCategory }
                .mapNotNull { (nameTypeCategory, money) ->
                    val totalMoney = money.sumOf { it.amountExpend }
                    val per = (totalMoney.toDouble() / total.toDouble()) * 100

                    PieEntry(per.toFloat(), nameTypeCategory)
                }
            _pieChartData.postValue(group)
        }

    }

    fun getDataBarChart(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "expend" }

            val grouped = groupType.groupBy { it.nameTypeCategory }

            val barEntries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()

            grouped.entries.forEachIndexed { index, entry ->
                val totalMoney = entry.value.sumOf { it.amountExpend }
                barEntries.add(BarEntry(index * 0.5f, totalMoney.toFloat()))

                labels.add(entry.key)
            }
            _barChart.postValue(barEntries)
        }
    }

    fun getDataStaticCategory(owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "expend" }

            val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")

            val groupedByMonth = groupType.groupBy { item ->
                val date = LocalDate.parse(item.dateExpend, formatter)
                "${date.monthValue}/${date.year}"
            }

            val bindView = groupedByMonth.map { (monthYear, items) ->

                val childList = items.groupBy { it.nameTypeCategory }
                    .map { (categoryName, list) ->

                        val totalCategory = list.sumOf { it.amountExpend }

                        StaticCategoryChildModel(
                            imgCategory = list.first().imgTypeCategory,
                            nameCategory = categoryName,
                            totalMoneyCategory = "$totalCategory đ",
                            progress = 50
                        )
                    }

                StaticCategoryParentModel(
                    date = monthYear,
                    list = childList
                )
            }

            _dataStatic.postValue(bindView)
        }
    }


}