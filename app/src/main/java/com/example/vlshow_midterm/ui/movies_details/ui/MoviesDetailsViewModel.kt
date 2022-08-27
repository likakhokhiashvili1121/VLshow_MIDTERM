package com.example.vlshow_midterm.ui.movies_details.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vlshow_midterm.model.CastItem
import com.example.vlshow_midterm.model.MoviesDetailsResponse
import com.example.vlshow_midterm.model.ResultsVideoItem
import com.example.vlshow_midterm.ui.movies_details.repository.MoviesDetailsRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MoviesDetailsViewModel : ViewModel() {
    private val TAG = "AllMoviesViewModel"
    private val moviesDetailsRepository= MoviesDetailsRepository()
    var listCastMovie = MutableLiveData<List<CastItem?>?>()
    var favorite = MutableLiveData<Boolean>()
    var trailerId = MutableLiveData<ResultsVideoItem?>()
    var movieDetails = MutableLiveData<MoviesDetailsResponse?>()


    fun getCastMovieList(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = moviesDetailsRepository.getCastMovieList(id)
            val trailer = moviesDetailsRepository.getTrailer(id)

            withContext(Main) {
                listCastMovie.postValue(list)
                trailerId.postValue(trailer)
            }
        }
    }
    fun getMoviesDetails(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = moviesDetailsRepository.getMoviesDetails(id)
            withContext(Main) {
                movieDetails.postValue(list)
            }
        }
    }

    fun getFavorite(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val exist=moviesDetailsRepository.getFavorite(id)
            withContext(Main){
                favorite.postValue(exist)
            }
        }
    }
    fun setFavorite(id:Int,poster:String,exist:Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesDetailsRepository.setFavorite(id,poster,exist)
        }
    }

}