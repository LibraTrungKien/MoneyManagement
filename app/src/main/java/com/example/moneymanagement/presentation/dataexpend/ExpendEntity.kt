package com.example.moneymanagement.presentation.dataexpend

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExpendEntity (

    @PrimaryKey(autoGenerate = true) val idExpend: Int,
    val amountExpend: Int,
    val nameTypeCategory: String,
    val imgTypeCategory: Int,
    val nameBudget: String,
    val imgBudget: Int,
    val note: String?,
    val dateExpend: String,
    val timeExpend: String
)


