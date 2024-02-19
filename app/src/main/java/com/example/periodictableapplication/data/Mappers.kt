package com.example.periodictableapplication.data

import com.example.periodictableapplication.data.api.model.PeriodicTable
import com.example.periodictableapplication.domain.model.Element
import com.example.periodictableapplication.data.api.model.ElementNW

fun ElementNW.toDomain(oldElement: ElementNW): Element {
    return Element(
        symbol = oldElement.symbol,
        atomicMass = oldElement.atomicMass.toString(),
        name = oldElement.name,
        number = oldElement.number,
        category = oldElement.category,
        period = oldElement.period,
        group = oldElement.group,
        source = oldElement.source,
        summary = oldElement.summary,
        imageUrl = oldElement.image.url,
        appearance = oldElement.appearance ?: "",
        discoveredBy = oldElement.discoveredBy ?: "",
        phase = oldElement.phase,
        engName = oldElement.engName,
        latinName = oldElement.latinName
    )
}