package com.example.basicactivitydemo.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WordDao {

    @Query("SELECT * FROM wordTable ORDER BY word ASC")
    fun getAllwords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM wordTable")
    suspend fun deleteAll()
}