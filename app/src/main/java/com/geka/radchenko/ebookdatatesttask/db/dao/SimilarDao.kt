package com.geka.radchenko.ebookdatatesttask.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.geka.radchenko.ebookdatatesttask.db.SIMILAR_TABLE
import com.geka.radchenko.ebookdatatesttask.db.SimilarTable

@Dao
abstract class SimilarDao : BaseDao<SimilarTable>() {
    @Query("SELECT * FROM $SIMILAR_TABLE")
     abstract fun getSimilarLive(): LiveData<List<SimilarTable>>
}