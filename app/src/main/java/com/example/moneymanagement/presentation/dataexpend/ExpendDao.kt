package com.example.moneymanagement.presentation.dataexpend

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExpendDao {
    @Query("SELECT * FROM ExpendEntity ORDER BY idExpend ASC")
    fun getAll(): LiveData<List<ExpendEntity>>

    @Insert
    suspend fun insertExpend(vararg expend: ExpendEntity)

    @Update
    fun updateExpend(updateExpend: ExpendEntity)

    @Delete
    fun deleteExpend(deleteExpend: ExpendEntity)

}