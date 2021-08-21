package com.erykhf.android.studentbeanschallenge.ui.main

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erykhf.android.studentbeanschallenge.api.RetroFitClient
import com.erykhf.android.studentbeanschallenge.model.PhotosData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhotoFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var photosLiveData : MutableLiveData<PhotosData> = MutableLiveData()

    init {
        photosLiveData = getPhotos()
    }

    fun refresh(){
        photosLiveData = getPhotos()
    }

    private fun getPhotos(): MutableLiveData<PhotosData> {

        val liveDataResponse: MutableLiveData<PhotosData> = MutableLiveData()
        val photoRequest: Call<PhotosData> = RetroFitClient.retrofitInstance.getPhotos()

        photoRequest.enqueue(object : Callback<PhotosData> {
            override fun onResponse(call: Call<PhotosData>, response: Response<PhotosData>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    val photoResponse: PhotosData? = response.body()
                    liveDataResponse.value = photoResponse
                } else {
                    when (response.code()) {
                        400 -> {
                            Log.e("TAG", "onResponse: ${response.message()} ${response.code()}")
                            Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        401 -> {
                            Log.e("TAG", "onResponse: ${response.message()} ${response.code()}")
                            Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        403 -> {
                            Log.e("TAG", "onResponse: ${response.message()} ${response.code()}")
                            Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        404 -> {
                            Log.e("TAG", "onResponse: ${response.message()} ${response.code()}")
                            Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        500 -> {
                            Log.e("TAG", "onResponse: ${response.message()} ${response.code()}")
                            Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        else -> Toast.makeText(
                            getApplication(),
                            "Network Error",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
            override fun onFailure(call: Call<PhotosData>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", t)
                Toast.makeText(getApplication(), "Network Error!", Toast.LENGTH_SHORT).show()
            }
        })
        return liveDataResponse
    }
}