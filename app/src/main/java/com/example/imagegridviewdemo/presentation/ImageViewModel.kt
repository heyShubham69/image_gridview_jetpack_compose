package com.example.imagegridviewdemo.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.imagegridviewdemo.data.ImageData
import com.example.imagegridviewdemo.domain.repository.ImageRepository
import kotlinx.coroutines.launch

class ImageViewModel(private val repository: ImageRepository) : ViewModel() {
    private val _imageData = MutableLiveData<ImageData>()
    val imageData: LiveData<ImageData> = _imageData

    fun fetchImages() {
        viewModelScope.launch {

            val images = fetchImageDataFromNetwork()
            _imageData.value = images

        }
    }

    private suspend fun fetchImageDataFromNetwork(): ImageData {
        val data: ImageData = try {
            repository.getImageData()
        } catch (e: Exception) {
            null!!
        }
        return data
    }
}

class ImageViewModelFactory(private val repository: ImageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }

}