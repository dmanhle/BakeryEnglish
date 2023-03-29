package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

class IntransitiveVerb(
    private val wordOfInstransitiveVerb:String?,
    private val exampleOfInstrantiveVerb:ArrayList<String>?
):Transform(wordOfInstransitiveVerb,exampleOfInstrantiveVerb) {
}