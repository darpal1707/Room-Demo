package com.example.basicactivitydemo.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordTable")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String){


}