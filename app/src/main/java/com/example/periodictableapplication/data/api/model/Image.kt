package com.example.periodictableapplication.data.api.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("attribution")
    val attribution: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)