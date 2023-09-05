package com.example.meme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    //pull interface
    val someInterface by lazy     {
        retrofit.create(ApiInterface::class.java)
    }
}