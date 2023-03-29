package com.plcoding.cleanarchitecturenoteapp.data.local.remote

import com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto.DefinitionsDTO
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto.WordInforDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictonaryApi {

    @GET("api/v2/entries/en/{word}")
    suspend fun getInforWordDTO(@Path("word") word:String): List<WordInforDTO>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}