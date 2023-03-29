package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

data class Noun(
    val wordOfNoun:String?,
    val listExampleOfNoun:ArrayList<String>?
):Transform(wordOfNoun,listExampleOfNoun) {
}