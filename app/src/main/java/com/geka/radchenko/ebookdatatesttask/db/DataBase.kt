package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geka.radchenko.ebookdatatesttask.db.dao.BestSellerDao

@Database(version = VERSION, exportSchema = false, entities = [BestSellerTable::class])
abstract class DataBase : RoomDatabase() {
    abstract fun bestSellerDao(): BestSellerDao

}

const val VERSION = 1
const val DATABASE_NAME = "appDb"