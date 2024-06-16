package com.example.imagegridviewdemo.data.repository

import com.example.imagegridviewdemo.data.ImageData
import com.example.imagegridviewdemo.domain.repository.ImageRepository
import com.example.imagegridviewdemo.network.APIService

class ImageRepositoryImpl(private val apiService: APIService): ImageRepository {

    override suspend fun getImageData(): ImageData {
        return apiService.fetchImageData()
    }

}