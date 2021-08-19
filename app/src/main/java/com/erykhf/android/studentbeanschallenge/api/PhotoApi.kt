package com.erykhf.android.studentbeanschallenge.api

import com.erykhf.android.studentbeanschallenge.model.PhotosData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotoApi {

    @Headers("Content-Type: application/json")
    @GET("photos")
    fun getPhotos(): Call<PhotosData>
}