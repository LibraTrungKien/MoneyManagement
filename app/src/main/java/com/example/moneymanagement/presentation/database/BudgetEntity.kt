package com.example.moneymanagement.presentation.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BudgetEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val moneyBudget : Int,

    val budgetName : String,



)