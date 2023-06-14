package com.example.movielist1.network

import com.example.movielist1.model.Movie
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies(): List<Movie>

    companion object{
        //url
        var baseUrl = ""

        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if(apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}