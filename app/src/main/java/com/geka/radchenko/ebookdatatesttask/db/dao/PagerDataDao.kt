package com.geka.radchenko.ebookdatatesttask.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.geka.radchenko.ebookdatatesttask.db.PAGER_DATA_TABLE
import com.geka.radchenko.ebookdatatesttask.db.PagerDataTable

@Dao
abstract class PagerDataDao : BaseDao<PagerDataTable>() {
    @Query("SELECT * FROM $PAGER_DATA_TABLE")
     abstract fun getPagerDataLive(): LiveData<List<PagerDataTable>>
}