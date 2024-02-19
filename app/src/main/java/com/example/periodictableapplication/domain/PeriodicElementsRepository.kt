package com.example.periodictableapplication.domain

import com.example.periodictableapplication.domain.model.Element

interface PeriodicElementsRepository {
    suspend fun getElements(): List<Element>
}