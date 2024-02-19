package com.example.periodictableapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.periodictableapplication.domain.PeriodicElementsRepository
import com.example.periodictableapplication.domain.model.Element
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val repository: PeriodicElementsRepository) :
    ViewModel() {
    private val _elements: MutableLiveData<List<Element>> = MutableLiveData()
    val elements: LiveData<List<Element>> get() = _elements
    private var allElements: List<Element> = emptyList()
    private var currentGroup: Int? = null

    init {
        loadElements()
    }

    private fun loadElements() {
        viewModelScope.launch(Dispatchers.IO) {
            val elements = repository.getElements()
            _elements.postValue(elements)
            allElements = elements
        }
    }

    fun searchElements(query: String) {
        val filteredElements = if (query.isBlank()) {
            allElements
        } else {
            allElements.filter { element ->
                element.name.contains(
                    query,
                    ignoreCase = true
                )
            }
        }
        _elements.value = filteredElements
    }

    fun filterElementsByGroup(periodNumber: Int?) {
        currentGroup = periodNumber
        val filteredElements = if (periodNumber == null) {
            allElements
        } else {
            allElements.filter { element ->
                element.period == periodNumber
            }
        }
        _elements.value = filteredElements
    }
}