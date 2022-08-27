package com.example.vlshow_midterm.ui.movies.repository

import com.example.vlshow_midterm.network.MoviesService
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.model.PopularResponse
import com.example.vlshow_midterm.util.API_KEY

class AllMoviesRepository {

   private  val TAG = "AllMoviesRepository"
    suspend fun getPopular(page: Int): PopularResponse? {
        val client= RetrofitClient.getInstance().create(MoviesService::class.java).getPopular(
            API_KEY,page)
        return client.body()
    }

    suspend fun getTopRated(page: Int): PopularResponse? {
        val client= RetrofitClient.getInstance().create(MoviesService::class.java).getTopRated(
            API_KEY,page)
        return client.body()
    }

    suspend fun getUpComing(page: Int): PopularResponse? {
        val client= RetrofitClient.getInstance().create(MoviesService::class.java).getUpComing(
            API_KEY,page)
        return client.body()
    }

    suspend fun getTrending(page: Int): PopularResponse? {
        val client = RetrofitClient.getInstance().create(MoviesService::class.java).getTrending(
            API_KEY, page)
        return client.body()
    }
}