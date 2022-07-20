package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SIMILAR_TABLE)
class SimilarTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SIMILAR_ID)
    val id: Int,
    @ColumnInfo(name = SIMILAR_IMAGE)
    val image: String
)

const val SIMILAR_TABLE = "similar_table"
const val SIMILAR_ID = "similar_id"
const val SIMILAR_IMAGE = "similar_image"