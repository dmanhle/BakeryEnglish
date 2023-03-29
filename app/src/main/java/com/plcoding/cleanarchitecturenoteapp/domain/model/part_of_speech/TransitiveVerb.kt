package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

class TransitiveVerb(
    private val wordOfTransitiveVerb:String?,
    private val exampleOfTransitiveVerb:ArrayList<String>?
):Transform(wordOfTransitiveVerb,exampleOfTransitiveVerb) {
}