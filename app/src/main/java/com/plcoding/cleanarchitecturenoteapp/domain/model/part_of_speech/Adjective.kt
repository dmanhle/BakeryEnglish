package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

class Adjective(
    private val wordOfAdjective:String?,
    private val listExampleOfAdjective:ArrayList<String>?
):Transform(wordOfAdjective,listExampleOfAdjective) {
}