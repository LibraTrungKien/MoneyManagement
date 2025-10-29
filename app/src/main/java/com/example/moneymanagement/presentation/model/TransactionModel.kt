package com.example.moneymanagement.presentation.model

data class TransactionParent(
    val date: String,
    val child: List<TransactionChild>
)


data class TransactionChild(

    val imgCategory: Int,
    val nameCategory: String?,
    val note: String,
    val time: String,
    val expendPrice: Int,
    val nameBudget: String
)