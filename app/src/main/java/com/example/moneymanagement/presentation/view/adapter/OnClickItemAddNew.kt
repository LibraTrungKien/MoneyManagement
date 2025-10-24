package com.example.moneymanagement.presentation.view.adapter

import com.example.moneymanagement.presentation.model.Category

interface OnClickItemAddNew {

    fun onClickListenerCategory(item: Category, position: Int)

    fun onClickListenerBudget(nameBudget : String)

    fun onCLickListenerDate(day: Int, month: Int, year: Int)

    fun onClickListerTime(minute: Int, hour: Int)

}