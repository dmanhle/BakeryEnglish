package com.plcoding.cleanarchitecturenoteapp.domain.repository

import com.plcoding.cleanarchitecturenoteapp.core.Resource
import com.plcoding.cleanarchitecturenoteapp.data.local.model.VocabularyLocal
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto.WordInforDTO
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface DataRepository {

     fun getVocabularyLocal(word:String): Flow<Resource<List<VocabularyLocal>>>

     fun getVocabularyApi(word: String):Flow<Resource<List<WordInforDTO>>>

     fun getLesson():Flow<Resource<List<Lesson>>>

}