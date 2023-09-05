package com.example.meme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
interface ApiInterface {
    //Get Responces
    @GET("gimme")
    fun getData() : Call<responseDataClassX>
}