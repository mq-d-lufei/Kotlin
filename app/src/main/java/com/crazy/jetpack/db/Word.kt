package com.crazy.jetpack.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)