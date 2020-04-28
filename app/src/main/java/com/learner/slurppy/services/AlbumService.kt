package com.learner.slurppy.services

import com.learner.slurppy.datamodels.AlbumDataModel
import com.learner.slurppy.datamodels.AlbumResponse
import com.learner.slurppy.util.RetrofitBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService{

    var albumService : AlbumService

    @GET("photos")
    fun getImages() :Call<List<AlbumResponse>>


}