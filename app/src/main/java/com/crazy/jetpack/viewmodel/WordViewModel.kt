package com.crazy.jetpack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.crazy.jetpack.db.Word
import com.crazy.jetpack.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository = WordRepository(application)

    val allWords: LiveData<List<Word>>

    init {
        allWords = repository.allWords
    }


//    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
//        repository.insertWord(word)
//    }

    fun insert(word: Word) {
        //repository.insertWord(word)
    }
}