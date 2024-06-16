package com.example.imagegridviewdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imagegridviewdemo.data.repository.ImageRepositoryImpl
import com.example.imagegridviewdemo.domain.repository.ImageRepository
import com.example.imagegridviewdemo.network.RetrofitInstance
import com.example.imagegridviewdemo.presentation.ImageGridScreen
import com.example.imagegridviewdemo.presentation.ImageViewModelFactory
import com.example.imagegridviewdemo.ui.theme.ImageGridViewDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = ImageRepositoryImpl(RetrofitInstance.api)
        val viewModelFactory = ImageViewModelFactory(repository)

        setContent {
            MaterialTheme {
                ImageGridScreen(viewModel = viewModel(factory = viewModelFactory))
            }
        }

    }
}
