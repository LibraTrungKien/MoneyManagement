package com.example.moneymanagement.presentation.view.addnewincome

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.Category

class AddNewIncomeViewModel : ViewModel() {

    private var data = mutableListOf<Category>()

    fun initData(): List<Category> {
        data.add(Category("Bills", R.drawable.ic_salary));
        data.add(Category("Rentals", R.drawable.ic_invest))
        data.add(Category("Medical", R.drawable.ic_business))
        data.add(Category("Investment", R.drawable.ic_interest))
        data.add(Category("Gift", R.drawable.ic_gift))
        data.add(Category("Other", R.drawable.ic_other))

        return data
    }

}