package com.example.moneymanagement.presentation.view.addnewactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.database.AddNewEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewViewModel : ViewModel() {

    private var data = MutableLiveData<List<AddNewEntity>>()
    private var type = MutableLiveData<String>()
    val typeAddNew: LiveData<String> get() = type
    private lateinit var appDatabase: AppDatabase

    fun setDataList(list: List<AddNewEntity>) {
        data.value = list
    }

    fun getDataList(): List<AddNewEntity>? = data.value

    fun setAppDataBase(database: AppDatabase) {
        appDatabase = database
    }

    fun setType(value: String){
        type.value = value
    }

    fun insertExpendEntity(
        amountExpend: Int,
        type: String,
        nameTypeCategory: String,
        imgTypeCategory: Int,
        nameBudget: String,
        note: String?,
        dateExpend: String,
        timeExpend: String,

    ) {
        val entity = AddNewEntity(
            idExpend = 0,
            type = type,
            amountExpend = amountExpend,
            nameTypeCategory = nameTypeCategory,
            imgTypeCategory = imgTypeCategory,
            nameBudget = nameBudget,
            note = note,
            dateExpend = dateExpend,
            timeExpend = timeExpend
        )
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.expendDao().insertExpend(entity)

        }
    }

}