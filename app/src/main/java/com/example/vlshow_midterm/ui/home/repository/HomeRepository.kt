package com.example.vlshow_midterm.ui.home.repository

import com.example.vlshow_midterm.network.MoviesService
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.model.PopularResultsItem
import com.example.vlshow_midterm.util.API_KEY

class HomeRepository {

    private val TAG = "HomeRepository"
    suspend fun getPopular(): List<PopularResultsItem>? {
        val client =
            RetrofitClient.getInstance().create(MoviesService::class.java).getPopular(API_KEY, 1)
        return client.body()?.results
    }

    suspend fun getTopRated(): List<PopularResultsItem>? {
        val client =
            RetrofitClient.getInstance().create(MoviesService::class.java).getTopRated(API_KEY, 1)
        return client.body()?.results
    }

    suspend fun getUpComing(): List<PopularResultsItem>? {
        val client =
            RetrofitClient.getInstance().create(MoviesService::class.java).getUpComing(API_KEY, 1)
        return client.body()?.results
    }

    suspend fun getTrending(): List<PopularResultsItem>? {
        val client =
            RetrofitClient.getInstance().create(MoviesService::class.java).getTrending(API_KEY, 1)
        return client.body()?.results
    }


}