package com.example.zedflex.data.models

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("@type") val type: String,
    val disambiguation: String,
    val id: String,
    val image: Image,
    val title: String,
    val titleType: String,
    val year: Int
)