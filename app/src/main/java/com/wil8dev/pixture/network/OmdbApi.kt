package com.wil8dev.pixture.network

import com.wil8dev.pixture.model.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val OMBD_API_KEY = "229e5323"

interface MovieApi {
    @GET("/")
    fun search(@Query("s") searchText: String, @Query("apikey") ombd_api_key: String = OMBD_API_KEY): Call<Search>

    @GET("/")
    fun getMovie(@Query("i") movieId: String, @Query("apikey") ombd_api_key: String = OMBD_API_KEY): Call<Search>
}