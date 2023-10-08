package com.example.marvel_demo.retrofit

import com.example.marvel_demo.retrofit.response.marvelResponse.MarvelResponse
import retrofit2.http.GET

interface Api {

    @GET("/jsondata/superheros.json")
    suspend fun getProduct(): MarvelResponse

}