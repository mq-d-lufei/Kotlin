package com.crazy.jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

const val queryAllWord: String = "select * from word_tabl order by word asc"

@Dao
interface WordDao {

    @Query(queryAllWord)
//  fun findAllWords(): List<Word>
    fun findAllWords(): LiveData<List<Word>>

    @Insert
    suspend fun insert(word: Word)

    @Query("delete from work_table")
    fun deleteAll()
}