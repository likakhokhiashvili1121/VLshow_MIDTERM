package com.example.vlshow_midterm.ui.person_list.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.vlshow_midterm.model.PersonsResponse
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.network.PersonsService
import com.example.vlshow_midterm.util.API_KEY
import kotlinx.coroutines.tasks.await

class PersonsRepository {
    private val auth = FirebaseAuth.getInstance()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val TAG = "PersonsRepository"

    suspend fun getPopular(page: Int): PersonsResponse? {
        val client = RetrofitClient.getInstance().create(PersonsService::class.java)
            .getPopular(API_KEY, page)
        return client.body()
    }

    suspend fun getAllFavorite(): MutableMap<String, Boolean> {
        val collectionReference =
            db.collection("Users").document(auth.currentUser?.uid.toString())
                .collection("FavoritePersons")
        val myMap: MutableMap<String, Boolean> = HashMap()
        val result = collectionReference.get().await()
        for (i in result)
            myMap[i["favoriteId"].toString()] = true
        return myMap
    }

}