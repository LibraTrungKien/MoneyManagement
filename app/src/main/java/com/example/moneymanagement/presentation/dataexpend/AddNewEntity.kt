package com.example.moneymanagement.presentation.dataexpend

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddNewEntity (

    @PrimaryKey(autoGenerate = true) val idExpend: Int,
    val type: String,
    val amountExpend: Int,
    val nameTypeCategory: String,
    val imgTypeCategory: Int,
    val nameBudget: String,
    val note: String?,
    val dateExpend: String,
    val timeExpend: String
)


