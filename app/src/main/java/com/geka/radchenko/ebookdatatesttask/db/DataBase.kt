package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geka.radchenko.ebookdatatesttask.db.dao.BestSellerDao
import com.geka.radchenko.ebookdatatesttask.db.dao.PagerDataDao
import com.geka.radchenko.ebookdatatesttask.db.dao.SimilarDao

@Database(
    version = VERSION,
    exportSchema = false,
    entities = [BestSellerTable::class, PagerDataTable::class, SimilarTable::class]
)
abstract class DataBase : RoomDatabase() {
    abstract fun bestSellerDao(): BestSellerDao
    abstract fun pagerDataDao(): PagerDataDao
    abstract fun similarDao(): SimilarDao

}

const val VERSION = 2
const val DATABASE_NAME = "appDb"