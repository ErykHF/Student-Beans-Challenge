package com.erykhf.android.studentbeanschallenge.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object RetroFitClient {


     val retrofitInstance: PhotoApi by lazy {

         val logging = HttpLoggingInterceptor()
         logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
         val client: OkHttpClient = OkHttpClient.Builder()
             .addInterceptor(logging)
             .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PhotoApi::class.java)
    }

}