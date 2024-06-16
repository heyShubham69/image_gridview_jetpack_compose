package com.example.imagegridviewdemo.domain.repository

import com.example.imagegridviewdemo.data.ImageData
import com.example.imagegridviewdemo.network.APIService

interface ImageRepository {
    suspend fun getImageData():ImageData
}