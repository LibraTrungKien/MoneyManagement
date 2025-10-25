package com.example.moneymanagement.presentation.view.expendfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.dataexpend.AppDatabase
import com.example.moneymanagement.presentation.dataexpend.ExpendEntity
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class ExpendViewModel() : ViewModel() {

    private val parentData = mutableListOf<TransactionParent>()
    private lateinit var appDatabase: AppDatabase
    private val allExpend: LiveData<List<ExpendEntity>> = appDatabase.ExpendDao().getAll()

    fun setAppDataBase(database: AppDatabase) {
        appDatabase = database
    }


    fun initData(): List<TransactionParent> {

        allExpend.value.let {  }

        val aprilTransactions = listOf(
            TransactionChild(
                imgCategory = R.drawable.ic_hmburger,
                nameCategory = "Ăn uống",
                contentCategory = "Bữa tối",
                time = System.currentTimeMillis() - 1000000,
                expendPrice = 8000
            ),

            TransactionChild(
                imgCategory = R.drawable.ic_hmburger,
                nameCategory = "Ăn uống",
                contentCategory = "Bữa sáng",
                time = System.currentTimeMillis() - 1000000,
                expendPrice = 8000
            ),

            TransactionChild(
                imgCategory = R.drawable.ic_hmburger,
                nameCategory = "Ăn uống",
                contentCategory = "Ăn lẩu",
                time = System.currentTimeMillis() - 1000000,
                expendPrice = 800000
            ),
        )

        parentData.add( TransactionParent(date = "Apr - 2025",aprilTransactions ) )
        parentData.add(TransactionParent("Apr 2024", aprilTransactions))

        return parentData
    }


}