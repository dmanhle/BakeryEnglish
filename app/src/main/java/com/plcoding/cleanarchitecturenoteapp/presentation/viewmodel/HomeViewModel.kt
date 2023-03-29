package com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.core.Resource
import com.plcoding.cleanarchitecturenoteapp.data.local.database.DictonaryDao
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import com.plcoding.cleanarchitecturenoteapp.domain.repository.DataRepository
import com.plcoding.cleanarchitecturenoteapp.presentation.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var dataRepository: DataRepository
) :ViewModel() {

    private var _loadIndicator = mutableStateOf(false);
    val loadIndicator: State<Boolean> =  _loadIndicator;

    private var _loadLesson = mutableStateOf(emptyList<Lesson>())
    val loadLesson:State<List<Lesson>> = _loadLesson;
    init {
        getLessonDao()
    }
    fun onEvent(event:Event){
        when(event){
            is Event.LoadLesson ->{
                getLessonDao()
            }
            is Event.ClickToIntroduceLesson ->{

            }
            else -> {}
        }
    }
    fun getLessonDao(){
        viewModelScope.launch {
            dataRepository.getLesson().onEach {
                when(it){
                    is Resource.Success ->{
                        _loadIndicator.value = false
                        if(it.data?.isNotEmpty() == true){
                            _loadLesson.value = it.data;
                        }
                    }
                    is Resource.Loading ->{
                        _loadIndicator.value = true
                    }
                    is Resource.Error ->{

                    }
                }
            }.launchIn(this)
        }
    }
}