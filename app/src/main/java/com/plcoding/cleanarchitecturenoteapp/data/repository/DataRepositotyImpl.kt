package com.plcoding.cleanarchitecturenoteapp.data.repository

import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.cleanarchitecturenoteapp.core.Resource
import com.plcoding.cleanarchitecturenoteapp.data.local.database.DictonaryDao
import com.plcoding.cleanarchitecturenoteapp.data.local.model.VocabularyLocal
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.DictonaryApi
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto.WordInforDTO
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson
import com.plcoding.cleanarchitecturenoteapp.domain.repository.DataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import java.security.cert.Extension

class DataRepositotyImpl(
    private val dao: DictonaryDao,
    private val dictonaryApi: DictonaryApi
) :DataRepository{
    override fun getVocabularyLocal(
        word: String
    ): Flow<Resource<List<VocabularyLocal>>> = flow {
        emit(Resource.Loading<List<VocabularyLocal>>("Loading....."));
        val list = dao.loadWordInfor(word)
        emit(Resource.Success<List<VocabularyLocal>>(list))
    }

    override fun getVocabularyApi(word: String): Flow<Resource<List<WordInforDTO>>> = flow{
            emit(Resource.Loading<List<WordInforDTO>>("Loading "))
            var list = emptyList<WordInforDTO>()
            try {
                 list = dictonaryApi.getInforWordDTO(word);
            }catch (e:HttpException){
                emit(Resource.Error<List<WordInforDTO>>("Lỗi e: ${e.response()}"))
            }catch (io:IOException){
                emit(Resource.Error<List<WordInforDTO>>("Không có kết nối mạng"))
            }
            emit(Resource.Success(data = list))
        }

    override fun getLesson(): Flow<Resource<List<Lesson>>>  = flow {
        emit(Resource.Loading<List<Lesson>>("Loading..."))
        var list = emptyList<Lesson>()
        try {
           list = dao.getAllLesson()
        }catch (io:IOException){
            emit(Resource.Error<List<Lesson>>("Lỗi io"))
        }catch (e:HttpException){
            emit(Resource.Error<List<Lesson>>("Lỗi e"))
        }
        emit(Resource.Success<List<Lesson>>(list))
    }
}