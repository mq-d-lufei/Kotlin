package com.crazy.jetpack.repository

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.crazy.jetpack.db.Word
import com.crazy.jetpack.db.WordDao
import com.crazy.jetpack.db.WordRoomDatabase

class WordRepository(application: Application) {

    private val wordDao: WordDao = WordRoomDatabase.getDatabase(application).wordDao()

    //Room在单独的线程上执行所有查询。观察到LiveData当数据发生变化就会通知观察者。
    val allWords: LiveData<List<Word>> = wordDao.findAllWords()

    @WorkerThread
    suspend fun insertWord(word: Word) {
        wordDao.insert(word)
    }
}