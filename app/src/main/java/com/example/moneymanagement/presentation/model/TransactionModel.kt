package com.example.moneymanagement.presentation.model

data class TransactionParent(
    val date: String,
    val child: List<TransactionChild>
)


data class TransactionChild(

    val imgCategory: Int,
    val nameCategory: String,
    val contentCategory: String,
    val time: Long,
    val expendPrice: Int

)