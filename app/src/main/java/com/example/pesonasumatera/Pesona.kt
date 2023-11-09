package com.example.pesonasumatera

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pesona(
    val name: String,
    val description: String,
    val photo: String,
    val jenisWst: String,
    val alamatWst: String
) : Parcelable
