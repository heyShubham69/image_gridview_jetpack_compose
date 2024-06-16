package com.example.imagegridviewdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.imagegridviewdemo.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ImageViewModel(private val repository: ImageRepository):ViewModel() {
    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    val imageData = liveData(Dispatchers.IO) {
        try {
            val data =repository.getImageData()
            emit(data)
        } catch (e: Exception) {
           _loading.update { false }
        }
    }
}

class ImageViewModelFactory(private val repository: ImageRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }

}