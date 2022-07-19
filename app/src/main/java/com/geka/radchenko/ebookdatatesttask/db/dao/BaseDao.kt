package com.geka.radchenko.ebookdatatesttask.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

abstract class BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(t: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(t: List<T>)

    @Delete
    abstract suspend fun delete(t: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(t: T): Int

    open suspend fun upsert(t: T) {
        if (insert(t) == -1L) {
            update(t)
        }
    }
}