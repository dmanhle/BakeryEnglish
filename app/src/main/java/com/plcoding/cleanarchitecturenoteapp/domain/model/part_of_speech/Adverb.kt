package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

class Adverb(
    private val wordOfAdverb:String?,
    private val listExampleOfAdverb:ArrayList<String>?
):Transform(wordOfAdverb,listExampleOfAdverb) {
}