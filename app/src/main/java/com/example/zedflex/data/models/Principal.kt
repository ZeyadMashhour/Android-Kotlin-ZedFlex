package com.example.zedflex.data.models

data class Principal(
    val billing: Int,
    val category: String,
    val characters: List<String>,
    val id: String,
    val legacyNameText: String,
    val name: String,
    val roles: List<Role>
)