package com.erykhf.android.studentbeanschallenge.api

import com.erykhf.android.studentbeanschallenge.model.PhotosData
import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {

    @GET("photos")
    fun getPhotos(): Call<PhotosData>
}