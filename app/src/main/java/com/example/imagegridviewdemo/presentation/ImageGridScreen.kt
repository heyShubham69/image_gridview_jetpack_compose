package com.example.imagegridviewdemo.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.imagegridviewdemo.R
import com.example.imagegridviewdemo.data.Thumbnail

@Composable
fun ImageGridScreen(viewModel: ImageViewModel) {
    val imageDataList by viewModel.imageData.observeAsState()
    LazyVerticalGrid(
        columns = GridCells
            .Fixed(3),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        imageDataList?.let {
            items(it) { rowItems ->

                ThumbnailImage(rowItems.thumbnail)
            }
        }
    }
}

@Composable
fun ThumbnailImage(thumbnail: Thumbnail) {
    val imageUrl = "${thumbnail.domain}/${thumbnail.basePath}/0/${thumbnail.key}"
    Log.d("ThumbnailImage", "thumbnail: $imageUrl")
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .crossfade(true)
            .placeholder(R.drawable.baseline_add_photo_alternate_24)
            .build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
    )
}