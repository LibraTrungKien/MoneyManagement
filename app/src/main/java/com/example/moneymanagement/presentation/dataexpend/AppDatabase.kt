package com.example.moneymanagement.presentation.dataexpend

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExpendEntity :: class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun ExpendDao() : ExpendDao
}