package com.example.moneymanagement.presentation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface AddBudgetDetailDao {

    @Query("SELECT * FROM BudgetEntity")
    fun getBudgetDetail() : LiveData<List<BudgetEntity>>

    @Insert
    suspend fun insertBudgetDetail(budgetEntity: BudgetEntity)

    @Query("UPDATE BudgetEntity SET moneyBudget = :newMoneyBudget WHERE id = :id ")
    suspend fun updateMoney(id: Int, newMoneyBudget: Int)

    @Delete
    suspend fun deleteBudget(budgetEntity: BudgetEntity)

}