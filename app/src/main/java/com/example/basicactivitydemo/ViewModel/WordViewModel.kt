package com.example.basicactivitydemo.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basicactivitydemo.Data.Word
import com.example.basicactivitydemo.Data.WordRoomDatabase
import com.example.basicactivitydemo.Repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (application: Application) : AndroidViewModel(application){

    // The ViewModel maintains a reference to the repository to get data.
    private var repository : WordRepository ?= null

    // LiveData gives us updated words when they change.
    var allWords: LiveData<List<Word>> ?= null

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository!!.allWords

    }

    // The implementation of insert() is completely hidden from the UI.
    // We don't want insert to block the main thread, so we're launching a new
    // coroutine. ViewModels have a coroutine scope based on their lifecycle called
    // viewModelScope which we can use here.

    fun insert(word: Word) = viewModelScope.launch {
        repository!!.insert(word)
    }
}