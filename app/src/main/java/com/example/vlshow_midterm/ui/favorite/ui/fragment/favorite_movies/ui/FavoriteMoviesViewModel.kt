package com.example.vlshow_midterm.ui.favorite.ui.fragment.favorite_movies.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vlshow_midterm.ui.favorite.model.FavoriteItem
import com.example.vlshow_midterm.ui.favorite.ui.fragment.favorite_movies.repository.FavoriteMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteMoviesViewModel : ViewModel() {
    private val moviesDetailsRepository= FavoriteMoviesRepository()
    var listFavoriteMovie = MutableLiveData<List<FavoriteItem>>()

    fun getFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            val favorite=moviesDetailsRepository.getFavorite()
            withContext(Dispatchers.Main){
                listFavoriteMovie.postValue(favorite)

            }
        }
    }
}