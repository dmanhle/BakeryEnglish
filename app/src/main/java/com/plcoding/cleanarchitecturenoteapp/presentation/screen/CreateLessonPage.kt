package com.plcoding.cleanarchitecturenoteapp.presentation.screen

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cleanarchitecturenoteapp.core.RouteScreen
import com.plcoding.cleanarchitecturenoteapp.domain.model.Lesson
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson
import com.plcoding.cleanarchitecturenoteapp.presentation.event.Event
import com.plcoding.cleanarchitecturenoteapp.presentation.screen.components.ComponentInsertVocabulary
import com.plcoding.cleanarchitecturenoteapp.presentation.screen.components.tablayout.HelloWord
import com.plcoding.cleanarchitecturenoteapp.presentation.screen.components.tablayout.TabSynonymous
import com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel.CreateLessonViewModel
import com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel.DictonaryViewModel
import androidx.compose.material.SwipeableDefaults


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateLessonPage(navController: NavController) {
    val createLessonViewModel:CreateLessonViewModel = hiltViewModel();
    val textFieldNameLesson = createLessonViewModel.textFieldCreateLesson;

    val composableList = remember {
        mutableStateListOf<@Composable () -> WordOfLesson>(
            { ComponentInsertVocabulary()},{ComponentInsertVocabulary()}
        )
    }
    val context = LocalContext.current;
    val scrollState = rememberScrollState();

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    composableList.add {
                       ComponentInsertVocabulary()
                    }
                },
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ){
                Icon(Icons.Filled.Add,"")
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Tạo học phần")
                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Navigation icon")
                    }
                },
                backgroundColor = Color.White,
                actions ={
                    IconButton(onClick = {
                        if (
                            createLessonViewModel.textFieldCreateLesson.value.isEmpty() ||
                            createLessonViewModel.listWordOfLesson.value.isEmpty()
                        ){
                            Toast.makeText(context,"Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
                        }else{
                            createLessonViewModel.onEvent(Event.SaveVocabularyLesson())
                            navController.navigate(RouteScreen.Home.route)
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = "description")
                    }
                }
            )
        },
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Gray.copy(0.05f))
    ){
        Box(modifier = Modifier
            .background(Color.Gray.copy(0.05f))
            .padding(10.dp)
            .verticalScroll(scrollState)
        ){
            Column(
            ) {
                TextField(
                    value = textFieldNameLesson.value.toString(),
                    onValueChange ={
                        createLessonViewModel.onEvent(Event.CreateLesson(it))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray.copy(0.05f))
                        .height(50.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                )
                Text(text = "Tiêu đề", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(40.dp))

                val listVocabulary = composableList.map{
                   it()
                }
                createLessonViewModel.updateData(listVocabulary);
            }
        }
    }
}








