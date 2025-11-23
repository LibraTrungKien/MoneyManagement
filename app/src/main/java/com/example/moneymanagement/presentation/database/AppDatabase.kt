package com.example.moneymanagement.presentation.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AddNewEntity :: class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun addNewDao() : AddNewDao
}