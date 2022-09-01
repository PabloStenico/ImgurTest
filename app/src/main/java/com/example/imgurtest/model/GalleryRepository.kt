package com.example.imgurtest.model

import androidx.lifecycle.MutableLiveData
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import com.example.imgurtest.Api


class GalleryRepository {

    private var galleryModel = MutableLiveData<GalleryModel >()

    fun getCats(search: String): MutableLiveData<GalleryModel > {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/gallery/search/?q=cats")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(Api::class.java)
        var call: Call<GalleryModel > = service.getCats("Client-ID 1ceddedc03a5d71", search)

        call.enqueue(object : Callback<GalleryModel > {
            override fun onResponse(call: Call<GalleryModel >, response: Response<GalleryModel>) {
                galleryModel.value = response.body()

            }

            override fun onFailure(call: Call<GalleryModel >, t: Throwable) {
            }
        })

        return galleryModel
    }

}