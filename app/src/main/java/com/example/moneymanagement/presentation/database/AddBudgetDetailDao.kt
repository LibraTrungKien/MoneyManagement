package com.example.moneymanagement.presentation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface AddBudgetDetailDao {

    @Query("SELECT * FROM BudgetEntity")
    fun getBudgetDetail() : LiveData<BudgetEntity>

    @Insert
    suspend fun insertBudgetDetail(budgetEntity: BudgetEntity)

    @Update
    suspend fun updateBudget(budgetEntity: BudgetEntity)

}