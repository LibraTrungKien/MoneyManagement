package com.example.moneymanagement.presentation.view.addnew

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.dataexpend.AppDatabase
import com.example.moneymanagement.presentation.dataexpend.ExpendEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewViewModel : ViewModel() {

    private var data = MutableLiveData<List<ExpendEntity>>()
    private lateinit var appDatabase: AppDatabase

    fun setDataList(list: List<ExpendEntity>) {
        data.value = list
    }

    fun getDataList(): List<ExpendEntity>? = data.value

    fun setAppDataBase(database: AppDatabase) {
        appDatabase = database
    }

    fun insertExpendEntity(
        amountExpend: Int,
        nameTypeCategory: String,
        imgTypeCategory: Int,
        nameBudget: String,
        imgBudget: Int,
        note: String?,
        dateExpend: String,
        timeExpend: String
    ) {
        val entity = ExpendEntity(
            idExpend = 0,
            amountExpend = amountExpend,
            nameTypeCategory = nameTypeCategory,
            imgTypeCategory = imgTypeCategory,
            nameBudget = nameBudget,
            imgBudget = imgBudget,
            note = note,
            dateExpend = dateExpend,
            timeExpend = timeExpend
        )
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.expendDao().insertExpend(entity)

        }
    }

}