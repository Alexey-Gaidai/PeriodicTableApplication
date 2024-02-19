package com.example.periodictableapplication.domain.model

import java.io.Serializable

data class Element(
    val symbol: String,
    val atomicMass: String,
    val name: String,
    val number: Int,
    val category: String,
    val period: Int,
    val group: Int,
    val imageUrl: String,
    val source: String,
    val summary: String,
    val appearance: String?,
    val discoveredBy: String?,
    val phase: String,
    val engName: String,
    val latinName: String
): Serializable
