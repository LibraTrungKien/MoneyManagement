package com.example.moneymanagement.presentation.view.adapter

import com.example.moneymanagement.presentation.model.TransactionChild

interface OnClickItemTransaction {

    fun onItemClick(item: TransactionChild, date: String)


}