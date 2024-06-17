package com.example.imagegridviewdemo

import android.app.Application
import coil.ImageLoader
import coil.disk.DiskCache
import coil.request.CachePolicy
import coil.util.CoilUtils
import okhttp3.OkHttpClient
import java.io.File

class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()


        // Create a custom ImageLoader with memory and disk cache
        val imageLoader = ImageLoader.Builder(this)
            .diskCache {
                DiskCache.Builder()
                    .directory(this.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.25) // Use 25% of available disk space
                    .build()
            }.build()

        // Set the custom ImageLoader as the default
        coil.ImageLoaderFactory { imageLoader }
    }
}