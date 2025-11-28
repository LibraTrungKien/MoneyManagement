package com.example.moneymanagement.presentation.view.jardetailactivity

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.database.BudgetEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JarDetailViewModel : ViewModel() {

    private lateinit var appDatabase: AppDatabase

    fun setAppDataBase(appDatabase: AppDatabase){
        this.appDatabase = appDatabase
    }

    fun deleteBudget(budgetEntity: BudgetEntity){
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.addBudget().deleteBudget(budgetEntity)
        }
    }

}