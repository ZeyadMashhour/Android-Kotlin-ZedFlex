package com.example.zedflex.data.models

data class MovieDetails(
    val meta: Meta,
    val type: String,
    val query: String,
    val results: List<Result>,
    val types: List<String>
)