package com.example.vlshow_midterm.ui.person_list.ui

import android.app.Dialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vlshow_midterm.model.PersonsResultsItem
import com.example.vlshow_midterm.ui.person_list.repository.PersonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonListViewModel : ViewModel() {
    private val TAG = "PersonListViewModel"
    private val personsRepository = PersonsRepository()
    var listPersons = MutableLiveData<List<PersonsResultsItem>>()
    var listFavoritePersons = MutableLiveData<MutableMap<String,Boolean>>()
    var list = mutableListOf<PersonsResultsItem>()
    private lateinit var dialog: Dialog
    private var page = 1
    fun myStart(dialog: Dialog) {
        this.dialog = dialog
        getPopular()
    }

    fun getPopular() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            val response1 = personsRepository.getPopular(page)
            list.addAll(response1?.personsResults!!)
            val response2 = personsRepository.getAllFavorite()
            withContext(Dispatchers.Main) {
                listFavoritePersons.postValue(response2)
                listPersons.postValue(list)
                dialog.cancel()
                page++
            }
        }
    }

}