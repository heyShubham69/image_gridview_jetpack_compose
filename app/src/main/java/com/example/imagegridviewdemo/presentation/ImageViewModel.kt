package com.example.imagegridviewdemo.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.imagegridviewdemo.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers

class ImageViewModel(private val repository: ImageRepository):ViewModel() {

    val imageData = liveData(Dispatchers.IO) {
        try {
            val data =repository.getImageData()
            emit(data)
        } catch (e: Exception) {
           Log.e("ImageViewModel", "Error fetching image data: ${e.message}")
        }
    }
}

class ImageViewModelFactory(private val repository: ImageRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }

}