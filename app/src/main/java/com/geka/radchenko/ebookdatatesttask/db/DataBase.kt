package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = VERSION, exportSchema = false, entities = [])
abstract class DataBase : RoomDatabase() {

}

const val VERSION = 0
const val DATABASE_NAME = "appDb"