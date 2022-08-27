package com.example.vlshow_midterm.ui.movies_details.repository

import com.example.vlshow_midterm.model.CastItem
import com.example.vlshow_midterm.model.MoviesDetailsResponse
import com.example.vlshow_midterm.model.ResultsVideoItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.vlshow_midterm.network.MoviesService
import com.example.vlshow_midterm.network.RetrofitClient
import com.example.vlshow_midterm.util.API_KEY
import kotlinx.coroutines.tasks.await

class MoviesDetailsRepository {
    private val TAG = "MoviesDetailsRepository"
    private val auth = FirebaseAuth.getInstance()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    suspend fun getCastMovieList(id: Int): List<CastItem?>? {
        val client = RetrofitClient.getInstance().create(MoviesService::class.java)
            .getCastMovieList(id, API_KEY)
        return client.body()?.cast
    }

    suspend fun getMoviesDetails(id: Int): MoviesDetailsResponse? {
        val client = RetrofitClient.getInstance().create(MoviesService::class.java)
            .getMoviesDetails(id, API_KEY)
        client.isSuccessful
        return client.body()
    }

    suspend fun getFavorite(id: Int): Boolean {
        val collectionReference =
            db.collection("Users").document(auth.currentUser?.uid.toString())
                .collection("FavoriteMovies").document(id.toString())
        val result = collectionReference.get().await()
        return result.exists()
    }

    suspend fun getTrailer(id: Int): ResultsVideoItem? {
        val client =
            RetrofitClient.getInstance().create(MoviesService::class.java).getTrailer(id, API_KEY)
        var resultsVideoItem: ResultsVideoItem? = null
        if (client.body()?.results != null) {
            for (i in client.body()?.results!!) {
                if (i?.type == "Trailer") {
                    resultsVideoItem = i
                    break
                } else {
                    resultsVideoItem = i
                }
            }
        }
        return resultsVideoItem
    }


    suspend fun setFavorite(id: Int, poster: String, exist: Boolean) {
        if (!exist) {
            val collectionReference =
                db.collection("Users").document(auth.currentUser?.uid.toString())
                    .collection("FavoriteMovies").document(id.toString())
            val map = HashMap<String, String>()
            map["poster"] = poster
            map["favoriteId"] = id.toString()
            collectionReference.set(map).await()
        } else {
            val collectionReference =
                db.collection("Users").document(auth.currentUser?.uid.toString())
                    .collection("FavoriteMovies").document(id.toString())
            collectionReference.delete().await()
        }
    }

}