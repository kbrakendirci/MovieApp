package com.example.movieapp.data.web.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class SpokenLanguage(
    val english_name: String?,
    val iso_639_1: String?,
    val name: String?
) {
}