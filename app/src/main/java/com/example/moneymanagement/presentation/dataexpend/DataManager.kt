package com.example.moneymanagement.presentation.dataexpend

import android.content.Context
import androidx.room.Room
import kotlin.reflect.KParameter

object DataManager {


    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDataBase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "data expend"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}