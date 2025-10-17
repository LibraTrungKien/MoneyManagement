package com.example.moneymanagement.presentation.model

data class ExpendParent(
    val date: String,
    val childExpend: List<ExpendChild>
)


data class ExpendChild(

    val imgCategory: Int,
    val nameCategory: String,
    val contentCategory: String,
    val time: Long,
    val expendPrice: Int

)