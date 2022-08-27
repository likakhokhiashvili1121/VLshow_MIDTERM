package com.example.vlshow_midterm.ui.search.fragment.person_search.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vlshow_midterm.model.ResultsItem
import com.example.vlshow_midterm.ui.search.fragment.person_search.repository.SearchPersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchPersonViewModel : ViewModel() {
    private val moviesDetailsRepository= SearchPersonRepository()
    var listSearchPerson = MutableLiveData<List<ResultsItem?>>()

    fun getSearchPersons(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response=moviesDetailsRepository.getSearchPerson(query)
            withContext(Dispatchers.Main){
                listSearchPerson.postValue(response.results!!)
            }
        }
    }}