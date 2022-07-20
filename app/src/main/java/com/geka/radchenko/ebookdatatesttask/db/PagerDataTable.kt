package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PAGER_DATA_TABLE)
class PagerDataTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = PAGER_DATA_ID)
    val id: Int,
    @ColumnInfo(name = PAGER_DATA_IMAGE)
    val image: String
)

const val PAGER_DATA_TABLE = "pager_data_table"
const val PAGER_DATA_ID = "pager_data_id"
const val PAGER_DATA_IMAGE = "pager_data_image"