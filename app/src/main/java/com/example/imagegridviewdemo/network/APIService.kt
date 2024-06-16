package com.example.imagegridviewdemo.network

import com.example.imagegridviewdemo.data.ImageData
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface APIService{
    @GET("content/misc/media-coverages?limit=100")
    suspend fun fetchImageData(): ImageData
}

