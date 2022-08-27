package com.example.vlshow_midterm.ui.login.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vlshow_midterm.ui.login.repository.LoginRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    var responseLiveData= MutableLiveData<String>()
    private val loginRepository= LoginRepository()
    fun login(email:String,password:String){
        viewModelScope.launch(IO){
            val response=loginRepository.login(email,password)
            withContext(Main){
                responseLiveData.postValue(response)
            }
        }
    }

}