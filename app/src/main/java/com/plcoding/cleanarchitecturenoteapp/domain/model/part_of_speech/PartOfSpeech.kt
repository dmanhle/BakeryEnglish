package com.plcoding.cleanarchitecturenoteapp.domain.model.part_of_speech

data class PartOfSpeech(
    val noun:List<Noun>?,
    val verb:List<Adverb>?,
    val adj:List<Adjective>?,
    val internerVerb:List<IntransitiveVerb>?,
    val externalVerb:List<TransitiveVerb>?,
    val interjection:List<Interjection>?,
) {
}