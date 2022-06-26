package com.godgod.feature.compose.glide

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.graphics.drawable.toBitmap
import com.godgod.feature.base.GlideApp
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

@Composable
fun GlideImage(
    modifier: Modifier,
    url: String,
    @DrawableRes placeHolder: Int? = null,
    @DrawableRes error: Int? = null
) {
    var glideState: GlideState by remember(key1 = url) { mutableStateOf(GlideState.None) }
    val glideRequest = GlideApp.with(LocalContext.current)

    LaunchedEffect(key1 = url) {
        callbackFlow {
            val target = CustomTarget(this)
            glideRequest
                .load(url)
                .apply { if (placeHolder != null) this.placeholder(placeHolder) }
                .error(error)
                .into(target)

            awaitClose {  }
        }.collect {
            glideState = it
        }
    }

    Box(modifier = modifier) {
        val drawable = glideState.getDrawable()

        if (drawable != null) Image(
            modifier = Modifier.fillMaxSize(),
            bitmap = drawable.toBitmap().asImageBitmap(),
            contentDescription = null
        )
    }
}