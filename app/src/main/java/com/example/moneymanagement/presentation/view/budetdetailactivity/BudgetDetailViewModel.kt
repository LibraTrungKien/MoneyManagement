package com.example.moneymanagement.presentation.view.budetdetailactivity

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.presentation.database.AppDatabase

class BudgetDetailViewModel : ViewModel() {

    private lateinit var appDatabase : AppDatabase

    fun setAppDataBase (appDatabase: AppDatabase){
        this.appDatabase = appDatabase
    }


    fun initData(){

    }



}