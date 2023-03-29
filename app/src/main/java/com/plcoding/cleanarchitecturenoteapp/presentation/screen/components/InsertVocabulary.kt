package com.plcoding.cleanarchitecturenoteapp.presentation.screen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BorderClear
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson
import com.plcoding.cleanarchitecturenoteapp.presentation.event.Event
import com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel.CreateLessonViewModel
import com.plcoding.cleanarchitecturenoteapp.presentation.viewmodel.DictonaryViewModel
import kotlinx.coroutines.Job

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComponentInsertVocabulary():WordOfLesson{

    val input1 = remember { mutableStateOf("") }

    val input2 = remember { mutableStateOf("") }

    var wordOfLesson = remember {
        WordOfLesson("","");
    }
    val swipeState = rememberSwipeableState(initialValue = 0f)

    Card(
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(2.dp),
        modifier = Modifier.swipeable(
            state = swipeState,
            anchors = mapOf(
                -200f to -200f,
                0f to 0f,
                200f to 200f
            ),
            orientation = Orientation.Vertical,
            resistance = null,
            reverseDirection = false,
        )
    ) {
        Column(
            Modifier.background(Color.White)
        ) {
            TextField(
                value = input1.value,
                onValueChange = {
                    input1.value = it
                    wordOfLesson.word = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(50.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Gray,
                    disabledIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    if (input1.value.isNotEmpty()) {
                        IconButton(
                            onClick = { input1.value = "" }, Modifier.size(13.dp)
                        ) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text,
                    autoCorrect = true,
                )
            )
            Text(
                text = "Thuật ngữ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                color = Color(0xFF008080)
            )
            Spacer(
                modifier = Modifier
                    .height(5.dp)
                    .background(Color.White),
            )
            TextField(
                value = input2.value,
                onValueChange = {
                    input2.value = it
                    wordOfLesson.meaning = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 10.dp, end = 10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Gray,
                    disabledIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    if (input2.value.isNotEmpty()) {
                        IconButton(onClick = { input2.value = "" }, Modifier.size(13.dp)) {
                            Icon(
                                Icons.Filled.Clear,
                                contentDescription = "Clear",
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text,
                    autoCorrect = true
                ),
            )
            Text(
                text = "Định nghĩa",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                color = Color(0xFF008080)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    return wordOfLesson
}
