package com.example.zedflex.data.models

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("@meta") val meta: Meta,
    @SerializedName("@type") val type: String,
    val query: String,
    val results: List<Result>,
    val types: List<String>
)