package com.plcoding.cleanarchitecturenoteapp.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.data.local.model.VocabularyLocal
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson
import kotlinx.coroutines.flow.Flow

@Dao
interface DictonaryDao {
    @Query("SELECT * FROM vocabularylocal WHERE word IN (:word)")
    suspend fun loadWordInfor(word: String): List<VocabularyLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lesson: Lesson)

    @Query("Select * from lesson")
    suspend fun getAllLesson():List<Lesson>;

    @Query("Select * from lesson where id = :ids " )
    suspend fun getLessonByID(ids:Int):Lesson
}