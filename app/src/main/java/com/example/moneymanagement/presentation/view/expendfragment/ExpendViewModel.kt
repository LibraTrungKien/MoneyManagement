package com.example.moneymanagement.presentation.view.expendfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.dataexpend.AppDatabase
import com.example.moneymanagement.presentation.dataexpend.ExpendDao
import com.example.moneymanagement.presentation.dataexpend.ExpendEntity
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class ExpendViewModel : ViewModel() {

    private lateinit var appDatabase: AppDatabase
    private lateinit var dao: ExpendDao
    val expendList: LiveData<List<ExpendEntity>>
        get() = dao.getAll()

    fun setAppDataBase(database: AppDatabase) {
        appDatabase = database
        dao = appDatabase.expendDao()
    }

    fun initData(list: List<ExpendEntity>): List<TransactionParent> {
        val grouped = list.groupBy { it.dateExpend }
        return grouped.map { (date, items) ->
            val children = items.map {
                TransactionChild(
                    imgCategory = it.imgTypeCategory,
                    nameCategory = it.nameTypeCategory,
                    note = it.note ?: "",
                    time = it.timeExpend,
                    expendPrice = it.amountExpend
                )
            }
            TransactionParent(date, children)
        }
    }
}
