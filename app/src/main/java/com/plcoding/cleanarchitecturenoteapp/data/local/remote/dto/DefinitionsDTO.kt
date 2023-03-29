package com.plcoding.cleanarchitecturenoteapp.data.local.remote.dto

data class DefinitionsDTO(
    val definition:String,
    val synonyms:List<String>,
    val antonyms:List<String>
) {
}