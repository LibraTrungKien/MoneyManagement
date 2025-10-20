package com.example.moneymanagement.presentation.view.adapter

import com.example.moneymanagement.presentation.model.Category

interface OnClickItemCategory {

    fun onClickListener(item: Category, position: Int)

}