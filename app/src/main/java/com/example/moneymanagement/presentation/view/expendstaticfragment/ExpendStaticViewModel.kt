package com.example.moneymanagement.presentation.view.expendstaticfragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.github.mikephil.charting.data.PieEntry

class ExpendStaticViewModel : ViewModel() {

    private val _pieChartData = MutableLiveData<List<PieEntry>>()
    val pieChartData: LiveData<List<PieEntry>> get() = _pieChartData

    fun setAppDataBase(db: AppDatabase, owner: LifecycleOwner) {

        db.expendDao().getAll().observe(owner) { expendList ->

            val groupType = expendList.filter { it.type == "expend" }
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


}