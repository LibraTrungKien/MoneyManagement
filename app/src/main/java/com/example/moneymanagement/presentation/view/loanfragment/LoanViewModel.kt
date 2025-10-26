package com.example.moneymanagement.presentation.view.loanfragment

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent

class LoanViewModel : ViewModel() {

    private var data = mutableListOf<TransactionParent>()


    fun initData(): List<TransactionParent> {

        val aprilTransactions = listOf(
            TransactionChild(
                imgCategory = R.drawable.ic_hmburger,
                nameCategory = "Ăn uống",
                note = "Bữa tối",
                time = "10:22",
                expendPrice = 8000
            ),
        )

        data.add( TransactionParent(date = "Apr - 2025",aprilTransactions ) )
        data.add(TransactionParent("Apr 2024", aprilTransactions))

        return data
    }
}