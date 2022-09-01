package com.example.imgurtest

import com.example.imgurtest.model.GalleryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
interface Api {

    @GET("/3/gallery/search/")
    fun getCats(
        @Header("Authorization") authorization: String,
        @Query("q") query: String
    ): Call<GalleryModel>

}