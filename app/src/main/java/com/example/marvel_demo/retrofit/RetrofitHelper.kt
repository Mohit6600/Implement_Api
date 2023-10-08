package com.example.marvel_demo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    const val Base_Url = "https://protocoderspoint.com"

    fun getInstance() : Api{
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()


        return retrofit.create((Api::class.java))
    }

}