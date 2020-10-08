package com.cloneprojects.milliyetnewsclone.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes


    fun Context.extGetDrawable(@DrawableRes drawableId: Int): Drawable =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            resources.getDrawable(drawableId, theme)
        } else {
            resources.getDrawable(drawableId)
        }