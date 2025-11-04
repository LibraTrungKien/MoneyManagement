package com.example.moneymanagement.presentation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AddNewDao {
    @Query("SELECT * FROM AddNewEntity ORDER BY idExpend DESC")
    fun getAll(): LiveData<List<AddNewEntity>>

    @Insert
    suspend fun insertExpend(vararg expend: AddNewEntity)

    @Update
    fun updateExpend(updateExpend: AddNewEntity)

    @Delete
    fun deleteExpend(deleteExpend: AddNewEntity)

    @Query("DELETE FROM AddNewEntity Where idExpend = :id")
    fun deleteById(id: Int)

    @Query("SELECT * FROM ADDNEWENTITY WHERE nameTypeCategory = :categoryName")
    suspend fun getItemCategory(categoryName : String) : List<AddNewEntity>

}