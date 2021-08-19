package com.erykhf.android.studentbeanschallenge.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.erykhf.android.studentbeanschallenge.model.PhotosData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object RetroFitClient {


    private val instance: PhotoApi by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PhotoApi::class.java)
    }


    fun getPhotos(): MutableLiveData<PhotosData> {

        val liveDataResponse: MutableLiveData<PhotosData> = MutableLiveData()
        val photoRequest: Call<PhotosData> = instance.getPhotos()

        photoRequest.enqueue(object : Callback<PhotosData> {
            override fun onResponse(call: Call<PhotosData>, response: Response<PhotosData>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    val photoResponse: PhotosData? = response.body()
                    liveDataResponse.value = photoResponse
                }
            }

            override fun onFailure(call: Call<PhotosData>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

        return liveDataResponse
    }
}