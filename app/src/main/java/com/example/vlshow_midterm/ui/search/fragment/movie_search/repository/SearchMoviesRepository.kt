package com.example.vlshow_midterm.ui.search.fragment.movie_search.repository

import com.example.vlshow_midterm.model.SearchMoviesResponse
import com.example.vlshow_midterm.network.MoviesService
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.util.API_KEY

class SearchMoviesRepository {
    suspend fun getSearchMovies(query:String): SearchMoviesResponse {
        val client= RetrofitClient.getInstance().create(MoviesService::class.java).getMoviesSearch(
            API_KEY,query)

        return client.body()!!
    }
}