package com.godgod.feature.base

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Priority
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class BaseGlide : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val calculator = MemorySizeCalculator.Builder(context).build()
        val bitmapPoolSize = calculator.bitmapPoolSize
        val memoryCacheSize = calculator.memoryCacheSize
        val diskCacheSize = 1024 * 1024 * 50 //50mb
        val scaleValue = if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.N) 1f else 0.5f
        val requestOptions = RequestOptions()
            .priority(Priority.NORMAL)
            .format(DecodeFormat.PREFER_RGB_565)
            .sizeMultiplier(scaleValue)
            .timeout(1000 * 10)

        builder.setBitmapPool(LruBitmapPool(bitmapPoolSize.toLong()))
            .setMemoryCache(LruResourceCache(memoryCacheSize.toLong()))
            .setDiskCache(InternalCacheDiskCacheFactory(context, "staypia_image_disk_cache", diskCacheSize.toLong()))
            .setDefaultRequestOptions(requestOptions)
            .setLogLevel(Log.ERROR)
    }
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}