package com.example.pahlawanindonesia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val deskripsi: String,
    val foto: Int
) : Parcelable
