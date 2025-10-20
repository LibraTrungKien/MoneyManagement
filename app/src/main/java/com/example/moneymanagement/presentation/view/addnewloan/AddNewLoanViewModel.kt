package com.example.moneymanagement.presentation.view.addnewloan

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.Category

class AddNewLoanViewModel : ViewModel() {

    private var data = mutableListOf<Category>()

    fun initData(): List<Category> {
        data.add(Category("Bills", R.drawable.ic_loan));
        data.add(Category("Rentals", R.drawable.ic_borrow))

        return data
    }

}