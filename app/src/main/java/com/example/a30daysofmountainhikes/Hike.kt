package com.example.a30daysofmountainhikes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hike(
    @DrawableRes val ImageResourceId: Int,
    @StringRes val StringResourceId: Int,
    val level: String,
    val mountain: String,
    val info: String,
    val day: Int,
    val trail: Int
)