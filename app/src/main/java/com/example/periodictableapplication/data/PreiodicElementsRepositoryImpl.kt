package com.example.periodictableapplication.data

import com.example.periodictableapplication.data.api.Service
import com.example.periodictableapplication.data.api.model.PeriodicTable
import com.example.periodictableapplication.domain.PeriodicElementsRepository
import com.example.periodictableapplication.domain.model.Element

class PeriodicElementsRepositoryImpl(private val api: Service) : PeriodicElementsRepository {
    override suspend fun getElements(): List<Element> {
        return try {
            val response = api.getTableElements()
            if (response.isSuccessful && response.body() != null)
                response.body()!!.elements.map { it.toDomain(it) }
            else
                emptyList()
        } catch (e: Throwable) {
            emptyList()
        }
    }
}