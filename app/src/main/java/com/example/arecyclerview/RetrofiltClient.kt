package com.example.arecyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface{

   @GET ("users")
   fun getUsers() : Call<List<Users>>
}

class RetrofiltClient {

    companion object{

        var myRetrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

    }
}