package com.example.moneymanagement.presentation.view.addnewloan

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.CategoryModel

class AddNewLoanViewModel : ViewModel() {

    private var data = mutableListOf<CategoryModel>()

    fun initData(): List<CategoryModel> {
        data.add(CategoryModel("Bills", R.drawable.ic_loan));
        data.add(CategoryModel("Rentals", R.drawable.ic_borrow))

        return data
    }

}