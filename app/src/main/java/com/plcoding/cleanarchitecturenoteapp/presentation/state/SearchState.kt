package com.plcoding.cleanarchitecturenoteapp.presentation.state

import com.plcoding.cleanarchitecturenoteapp.data.local.model.VocabularyLocal
import com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto.TypeOfAudio

data class SearchState(
    var listVocabulary:List<VocabularyLocal> = emptyList(),
    val isIndicatorLoading:Boolean = false, // when search, we need update listVocabluary and display into screen, indicator will is called
    val message:String = "",
    val audio:TypeOfAudio = TypeOfAudio("","")
) {
}