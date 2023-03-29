package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

class Interjection(
    private val wordOfInterjection: String?,
    private val exampleOfInterjection:ArrayList<String>?
):Transform(wordOfInterjection,exampleOfInterjection){
}