package com.erykhf.android.studentbeanschallenge.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erykhf.android.studentbeanschallenge.api.RetroFitClient
import com.erykhf.android.studentbeanschallenge.model.PhotosData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var photosLiveData : MutableLiveData<PhotosData> = MutableLiveData()

    init {
        photosLiveData = RetroFitClient.getPhotos()
    }

}