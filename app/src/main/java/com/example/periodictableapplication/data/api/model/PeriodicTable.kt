package com.example.periodictableapplication.data.api.model

import com.google.gson.annotations.SerializedName

data class PeriodicTable(
    @SerializedName("elements")
    val elements: List<ElementNW>
)
