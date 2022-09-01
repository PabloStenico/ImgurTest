package com.example.imgurtest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatsViewModel : ViewModel() {

    private var _cats: MutableLiveData<GalleryModel>? = null


    fun getcats(search: String): LiveData<GalleryModel>?{
        _cats = GalleryRepository().getCats("cats")
        return _cats
    }

}