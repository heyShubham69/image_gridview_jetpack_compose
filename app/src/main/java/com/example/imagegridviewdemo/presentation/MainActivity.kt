package com.example.imagegridviewdemo.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
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

