package com.example.moneymanagement.presentation.view.addnewexpend

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.Category

class AddNewExpendViewModel : ViewModel() {

    private var data = mutableListOf<Category>()

    fun initData() : List<Category>{
            data.add(Category("Food", R.drawable.ic_hmburger))
            data.add(Category("Social", R.drawable.ic_socical))
            data.add(Category("Traffic", R.drawable.ic_traffic))
            data.add(Category("Shopping", R.drawable.ic_shooping))
            data.add(Category("Grocery", R.drawable.ic_grocery))
            data.add(Category("Education", R.drawable.ic_education))
            data.add(Category("Bills", R.drawable.ic_bill))
            data.add(Category("Rentals", R.drawable.ic_rent))
            data.add(Category("Medical", R.drawable.ic_medical))
            data.add(Category("Investment", R.drawable.ic_investment))
            data.add(Category("Gift", R.drawable.ic_gift))
            data.add(Category("Other", R.drawable.ic_other))
        return data
    }

}