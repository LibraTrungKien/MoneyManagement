package com.example.moneymanagement.presentation.view.incomfragment

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class IncomeViewModel : ViewModel(){

    private val parentData = mutableListOf<TransactionParent>()

    fun initData(): List<TransactionParent> {

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