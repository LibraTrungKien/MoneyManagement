package com.example.moneymanagement.presentation.view.loanfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.dataexpend.AddNewDao
import com.example.moneymanagement.presentation.dataexpend.AddNewEntity
import com.example.moneymanagement.presentation.dataexpend.AppDatabase
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class LoanViewModel : ViewModel() {

    private lateinit var appDatabase: AppDatabase
    private lateinit var dao: AddNewDao
    val loanList: LiveData<List<AddNewEntity>>
        get() = dao.getAll()


    fun setAppDatabase(appDatabase: AppDatabase) {
        this.appDatabase = appDatabase
        dao = appDatabase.expendDao()
    }

    fun initData(list: List<AddNewEntity>): List<TransactionParent> {

        val parent = list.groupBy { it.dateExpend }
        return parent.map { (date , item) ->
            val child = item.map {
                TransactionChild(
                    imgCategory = it.imgTypeCategory,
                    nameCategory = it.nameTypeCategory,
                    note = it.note ?: "",
                    time = it.timeExpend,
                    expendPrice = it.amountExpend
                )
            }
            TransactionParent(date, child)

        }
    }
}