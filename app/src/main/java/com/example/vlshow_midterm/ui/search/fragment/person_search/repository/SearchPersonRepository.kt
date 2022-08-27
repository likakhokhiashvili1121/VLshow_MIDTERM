package com.example.vlshow_midterm.ui.search.fragment.person_search.repository

import com.example.vlshow_midterm.model.SearchPersonResponse
import com.example.vlshow_midterm.network.MoviesService
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.util.API_KEY

class SearchPersonRepository {
    suspend fun getSearchPerson(query:String): SearchPersonResponse {
        val client= RetrofitClient.getInstance().create(MoviesService::class.java).getPersonsSearch(
            API_KEY,query)

        return client.body()!!
    }
}