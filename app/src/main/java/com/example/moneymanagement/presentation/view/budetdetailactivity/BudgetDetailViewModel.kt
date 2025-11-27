package com.example.moneymanagement.presentation.view.budetdetailactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.database.BudgetEntity
import com.example.moneymanagement.presentation.view.adapter.OnClickListenerUpdateMoney
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BudgetDetailViewModel : ViewModel() {

    private lateinit var appDatabase: AppDatabase

    private val _getData = MutableLiveData<List<BudgetEntity>>()
    val getData : LiveData<List<BudgetEntity>> get() = _getData

    fun setAppDataBase(appDatabase: AppDatabase) {
        this.appDatabase = appDatabase
    }

    fun initData(name: String, money: Int) {
        val data = BudgetEntity(id = 0, nameBudget = name, moneyBudget = money)
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.addBudget().insertBudgetDetail(data)
            getData()
        }
    }

    fun updateMoney(id: Int, newMoney: Int ){
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.addBudget().updateMoney(id, newMoney)
            getData()
        }
    }

    fun getData(){
        CoroutineScope(Dispatchers.IO).launch {
            val list = appDatabase.addBudget().getBudgetDetail()
            _getData.postValue(list)
        }
    }

}
