package com.example.moneymanagement.presentation.view.incomfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.dataexpend.AppDatabase
import com.example.moneymanagement.presentation.dataexpend.AddNewDao
import com.example.moneymanagement.presentation.dataexpend.AddNewEntity
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class IncomeViewModel : ViewModel() {

    private lateinit var appDatabase: AppDatabase
    private lateinit var dao: AddNewDao
    val incomeList: LiveData<List<AddNewEntity>>
        get() = dao.getAll()


    fun setAppDataBase(database: AppDatabase) {
        appDatabase = database
        dao = appDatabase.expendDao()
    }

    fun initData(list: List<AddNewEntity>): List<TransactionParent> {
        val parent = list.groupBy { it.dateExpend }
        return parent.map { (date, items) ->
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