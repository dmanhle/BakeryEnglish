package com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.data.local.database.DictonaryDao
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson
import com.plcoding.cleanarchitecturenoteapp.presentation.event.Event
import com.plcoding.cleanarchitecturenoteapp.presentation.screen.components.ComponentInsertVocabulary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateLessonViewModel @Inject constructor(
    private val dictonaryDao: DictonaryDao
):ViewModel() {
   private var _textFieldCreateLesson = mutableStateOf("");
   val textFieldCreateLesson: State<String> = _textFieldCreateLesson;


   private var _listWordOfLesson = mutableStateOf(emptyList<WordOfLesson>());
   var listWordOfLesson:State<List<WordOfLesson>> = _listWordOfLesson



   fun onEvent(event: Event){
      when(event){
         is Event.CreateLesson -> {
            _textFieldCreateLesson.value = event.lesson;
         }
         is Event.SaveVocabularyLesson ->{
            viewModelScope.launch {
               if (textFieldCreateLesson.value.isNotEmpty() && listWordOfLesson.value.isNotEmpty()){
                  dictonaryDao.insertLesson(Lesson(null,textFieldCreateLesson.value,listWordOfLesson.value))
               }
            }
         }
      }
   }
   fun updateData(list:List<WordOfLesson>){
      _listWordOfLesson.value = list
   }
}