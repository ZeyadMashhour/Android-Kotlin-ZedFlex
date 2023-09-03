package com.example.zedflex.data.models

data class Result(
    val id: String,
    val image: Image,
    val principals: List<Principal>,
    val runningTimeInMinutes: Int,
    val title: String,
    val titleType: String,
    val year: Int
)