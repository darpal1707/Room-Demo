package com.example.basicactivitydemo.Repository

import androidx.lifecycle.LiveData
import com.example.basicactivitydemo.Data.Word
import com.example.basicactivitydemo.Data.WordDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO

class WordRepository (private val wordDao: WordDao){

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    val allWords: LiveData<List<Word>> = wordDao.getAllwords()

    // The suspend modifier tells the compiler that this must be called from a
    // coroutine or another suspend function.

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}