package com.plcoding.cleanarchitecturenoteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Lesson(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    var nameLesson:String,
    var listVocabularyLesson:List<WordOfLesson>?
) {
}